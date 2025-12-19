package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.openapi.application.EDT
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.FileContentUtilCore
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import java.util.concurrent.ConcurrentHashMap
import kotlin.time.Duration.Companion.seconds

private val LOG = logger<BrowserslistService>()

data class Section(val name: SectionName, val queries: String, val textRange: TextRange)
sealed class SectionResult {
    abstract val name: SectionName
    abstract val queries: String

    data class Success(
        override val name: SectionName,
        override val queries: String,
        val result: BrowserslistResult
    ) : SectionResult()

    data class Error(
        override val name: SectionName,
        override val queries: String,
        val message: String,
        val cause: Throwable? = null
    ) : SectionResult()
}

@Service(Service.Level.PROJECT)
@OptIn(FlowPreview::class)
class BrowserslistService(private val project: Project, cs: CoroutineScope) {

    companion object {
        @JvmStatic
        fun getInstance(project: Project): BrowserslistService = project.service()
    }

    private val evalRequests = MutableSharedFlow<EvalRequest>(
        replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val updateEditorRequests = MutableSharedFlow<Unit>(
        replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    // Cache: file path -> section name -> result
    private val cache = ConcurrentHashMap<String, MutableMap<SectionName, SectionResult>>()

    init {
        cs.launch {
            evalRequests
                .debounce(1.seconds)
                // We do cache checks before requests, so if request is send then there is no need to deduplicate it
                .collectLatest { request ->
                    LOG.debug("Processing request for sections: ${request.sections}")
                    val results = request.sections.associateWith {
                        val result = withContext(Dispatchers.IO) {
                            BrowserslistExecutor.executeBrowserslist(
                                project, queries = it.queries, configFile = request.file
                            )
                        }
                        LOG.debug("Got results for section [${it.name}] - ${it.queries}: ${result?.coverage?.global}.")
                        result
                    }
                    ensureActive()
                    results.forEach { (section, result) ->
                        LOG.debug("Updating section cache  [${section.name}] - ${section.queries}: ${result?.coverage?.global}")
                        request.cache[section.name] =
                            if (result != null) SectionResult.Success(
                                section.name,
                                section.queries,
                                result
                            ) else SectionResult.Error(
                                section.name,
                                section.queries,
                                "Browserslist execution failed"
                            )

                    }
                    updateEditorRequests.tryEmit(Unit)
                }
        }

        cs.launch {
            updateEditorRequests.debounce(1.seconds).collectLatest {
                withContext(Dispatchers.EDT) {
                    val editors = EditorFactory.getInstance().allEditors
                    for (editor in editors) {
                        if (editor.project == project) {
                            FileContentUtilCore.reparseFiles(editor.virtualFile)
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets browserslist result for given sections
     * Returns cached result if available, otherwise triggers async computation.
     */
    fun getFileResult(file: VirtualFile, sections: Collection<Section>): Collection<SectionResult>? {
        if (!file.isInLocalFileSystem || !file.isValid) return null
        LOG.debug("Getting section result for sections: $sections")

        // Get or create cache for this file
        var fileCache = cache[file.path]
        if (fileCache == null) {
            fileCache = ConcurrentHashMap()
            cache.putIfAbsent(file.path, fileCache)
        }
        sections.distinctBy { it.name }.filter { section ->
            val cached = fileCache[section.name]
            cached == null || cached.queries != section.queries
        }
            .takeIf { it.isNotEmpty() }
            ?.let {
                LOG.debug("Triggering update for sections: $it")
                triggerUpdate(file, it, fileCache)
            }
        return fileCache.values
    }

    private fun triggerUpdate(
        file: VirtualFile, sections: Collection<Section>, cache: MutableMap<SectionName, SectionResult>
    ) {
        evalRequests.tryEmit(EvalRequest(file, sections, cache))
    }

    private data class EvalRequest(
        val file: VirtualFile, val sections: Collection<Section>, val cache: MutableMap<SectionName, SectionResult>
    )
}

@JvmInline
value class SectionName(val name: String)
