package com.github.aleksandrsl.intellijbrowserslist.codevision

import com.github.aleksandrsl.intellijbrowserslist.Section
import com.github.aleksandrsl.intellijbrowserslist.collectQueriesBySection
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistFile
import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionHost
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider
import com.intellij.json.psi.JsonFile
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile

abstract class BrowserslistCoverageStatsBaseCodeVisionProvider : DaemonBoundCodeVisionProvider {

    override val groupId: String = CODE_VISION_GROUP_ID
    override val defaultAnchor: CodeVisionAnchorKind = CodeVisionAnchorKind.Right

    private fun acceptsFile(file: PsiFile): Boolean {
        return file is BrowserslistFile || file is JsonFile && file.name == "package.json"
    }

    override fun computeForEditor(editor: Editor, file: PsiFile): List<Pair<TextRange, CodeVisionEntry>> {
        if (file.project.isDefault) return emptyList()
        if (!acceptsFile(file)) return emptyList()

        // we want to let this provider work only in tests dedicated for code vision, otherwise they harm performance
        if (ApplicationManager.getApplication().isUnitTestMode && !CodeVisionHost.Companion.isCodeLensTest()) return emptyList()

        val virtualFile = file.viewProvider.virtualFile
        if (ProjectFileIndex.getInstance(file.project).isInLibrarySource(virtualFile)) return emptyList()

        return when (file) {
            is BrowserslistFile -> buildEntriesForBrowserslistFile(file)
            is JsonFile -> buildEntriesForJsonFile(file)
            else -> emptyList()
        }
    }

    abstract fun buildForQueries(
        file: PsiFile,
        queriesBySection: Collection<Section>
    ): List<Pair<TextRange, CodeVisionEntry>>

    private fun buildEntriesForBrowserslistFile(file: BrowserslistFile): List<Pair<TextRange, CodeVisionEntry>> {
        val queriesBySection = collectQueriesBySection(file)
        if (queriesBySection.isEmpty()) return emptyList()
        return buildForQueries(file, queriesBySection)
    }

    private fun buildEntriesForJsonFile(file: JsonFile): List<Pair<TextRange, CodeVisionEntry>> {
        val queriesBySection = collectQueriesBySection(file)
        if (queriesBySection.isEmpty()) return emptyList()
        return buildForQueries(file, queriesBySection)
    }
}
