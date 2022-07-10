package com.github.aleksandrsl.intellijbrowserslist

//import com.intellij.javascript.nodejs.execution.NodeTargetRun
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.javascript.nodejs.interpreter.NodeCommandLineConfigurator
import com.intellij.javascript.nodejs.library.yarn.YarnPnpNodePackage
import com.intellij.javascript.nodejs.util.NodePackage
import com.intellij.lang.javascript.service.*
import com.intellij.lang.javascript.service.protocol.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.io.FileUtil
import com.intellij.util.Consumer
import com.intellij.util.EmptyConsumer
import com.intellij.util.PathUtil
import com.intellij.util.concurrency.FutureResult
import com.jetbrains.rd.util.string.printToString
import java.io.File
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future


class BrowserslistLanguageServiceImpl(project: Project) : JSLanguageServiceBase(project), BrowserslistLanguageService {
    private val LOG: Logger = Logger.getInstance(BrowserslistLanguageServiceImpl::class.java)

    @Volatile
    private var myFlushConfigCache = false

    init {
//        project.messageBus.connect(this).subscribe(VirtualFileManager.VFS_CHANGES, object : BulkFileListener {
//            override fun after(events: List<VFileEvent>) {
//                for (event in events) {
////                    Если поменялся конфиг или что-то еще, то скинь кэш.
////                    if (event !is VFileContentChangeEvent || PrettierUtil.isConfigFileOrPackageJson(event.file)) {
////                        myFlushConfigCache = true
////                        break
////                    }
//                }
//            }
//        })
    }

    override fun coverage(
        filePath: String,
        browserslistPackage: NodePackage,
    ): Future<BrowserslistLanguageService.CoverageResult>? {
        var filePath = filePath
        val process = process
        LOG.warn("Insie coverage ${process?.isValid.toString()}")
        if (process == null || !process.isValid) {
            return CompletableFuture.completedFuture(
                BrowserslistLanguageService.CoverageResult.error(BrowserslistBundle.message("progress.title"))
            )
        }
        LOG.warn("Before command execution")
        val command = CoverageCommand(myProject, filePath, browserslistPackage, queries = arrayOf())
//        return FutureResult(BrowserslistLanguageService.CoverageResult.result(10.0f))
        return sendCommand(command) { jsLanguageServiceObject, jsLanguageServiceAnswer ->
            LOG.warn("KEKE")
            LOG.warn(jsLanguageServiceAnswer.element.printToString())
            BrowserslistLanguageService.CoverageResult.result(10.0f)
        }
//        return process.execute(command,
//            JSLanguageServiceCommandProcessor { jsLanguageServiceObject, jsLanguageServiceAnswer ->
//                LOG.warn("KEKE")
//                LOG.warn(jsLanguageServiceAnswer.element.printToString())
//
//                BrowserslistLanguageService.CoverageResult.result(10.0f)
//            })
    }


    override fun createLanguageServiceQueue(): JSLanguageServiceQueue {
        return JSLanguageServiceQueueImpl(
            myProject,
            Protocol(myProject, EmptyConsumer.getInstance<Any>()),
            myProcessConnector,
            myDefaultReporter,
            JSLanguageServiceDefaultCacheData()
        )
    }

    override fun needInitToolWindow(): Boolean {
        return false
    }

    private class Protocol constructor(project: Project, readyConsumer: Consumer<*>) :
        JSLanguageServiceNodeStdProtocolBase("browserslist", project, readyConsumer) {
        private val LOG: Logger = Logger.getInstance(Protocol::class.java)
//        override fun addNodeProcessAdditionalArguments(commandLine: GeneralCommandLine) {
//            super.addNodeProcessAdditionalArguments(commandLine)
//            commandLine.exePath = JSLanguageServiceUtil.getPluginDirectory(
//                this.javaClass, "browserslistLanguageService"
//            ).absolutePath
//        }

//        override fun getWorkingDirectory(): String {
//            val application = ApplicationManager.getApplication()
//            if (application != null && application.isUnitTestMode) {
//                // `myProject.getBasePath()` returns a non-existent directory in unit test mode
//                // The problem is that Yarn Pnp can't detect .pnp.cjs when process is started in a non-existent directory.
//                val file = myProject.guessProjectDir()
//                if (file != null) {
//                    return file.path
//                }
//            }
//            return super.getWorkingDirectory()
//        }

//        // TODO: 7/9/22 Don't get this
//        override fun needReadActionToCreateState(): Boolean {
//            // PrettierPostFormatProcessor runs under write action. Read action here is not needed and it would block the service startup
//            return false
//        }

        override fun createState(): JSLanguageServiceInitialState {
            val state = JSLanguageServiceInitialState()
            val service = File(
                JSLanguageServiceUtil.getPluginDirectory(this.javaClass, "browserslistLanguageService"),
                "browserslist-plugin-provider.js"
            )
            if (!service.exists()) {
                JSLanguageServiceQueue.LOGGER.error("browserslist language service plugin not found")
            }
            state.pluginName = "browserslist-intellij"
            state.pluginPath = LocalFilePath.create(service.absolutePath)
            return state
        }

        override fun dispose() {}
//        override fun getNodeCommandLineConfiguratorOptions(project: Project): NodeCommandLineConfigurator.Options {
//            return NodeCommandLineConfigurator.defaultOptions(myProject)
//        }
    }

    private class CoverageCommand constructor(
        project: Project, filePath: String, browserslistPackage: NodePackage, queries: Array<String>
    ) : JSLanguageServiceObject, JSLanguageServiceSimpleCommand {
        override fun toSerializableObject(): JSLanguageServiceObject {
            return this
        }
        override fun getCommand() = "GetCoverage"

        override fun getPresentableText(project: Project): String {
            return BrowserslistBundle.message("progress.title")
        }
    }

//    private class ReformatFileCommand internal constructor(
//        project: Project,
//        filePath: String,
//        browserslistPackage: NodePackage,
//        ignoreFilePath: String?,
//        content: String,
//        range: TextRange?,
//        flushConfigCache: Boolean
//    ) :
//        JSLanguageServiceObject, JSLanguageServiceSimpleCommand {
//        val path: LocalFilePath?
//        val browserslistPath: LocalFilePath?
//        val packageJsonPath: LocalFilePath?
//        val ignoreFilePath: String?
//        val content: String
//        var start: Int? = null
//        var end: Int? = null
//        val flushConfigCache: Boolean
//
//        init {
//            path = LocalFilePath.create(filePath)
//            val pair = createPackagePath(project, prettierPackage)
//            prettierPath = pair.first
//            packageJsonPath = pair.second
//            this.ignoreFilePath = ignoreFilePath
//            this.content = content
//            this.flushConfigCache = flushConfigCache
//            if (range != null) {
//                start = range.startOffset
//                end = range.endOffset
//            }
//        }
//
//        override fun toSerializableObject(): JSLanguageServiceObject {
//            return this
//        }
//
//        override fun getCommand(): String {
//            return "reformat"
//        }
//
//        override fun getPresentableText(project: Project): String? {
//            return BrowserslistBundle.message("progress.title")
//        }
//
//        companion object {
//            private fun createPackagePath(
//                project: Project,
//                prettierPackage: NodePackage
//            ): Pair<LocalFilePath?, LocalFilePath?> {
//                val packagePath: String
//                var packageJsonPath: String?
//                if (prettierPackage is YarnPnpNodePackage) {
//                    val pnpPkg = prettierPackage
//                    packagePath = pnpPkg.name
//                    packageJsonPath = pnpPkg.getPackageJsonPath(project)
//                    checkNotNull(packageJsonPath) { "Cannot find package.json for $pnpPkg" }
//                    packageJsonPath = FileUtil.toSystemDependentName(packageJsonPath)
//                } else {
//                    packagePath = prettierPackage.systemDependentPath
//                    packageJsonPath = null
//                }
//                return Pair.create(LocalFilePath.create(packagePath), LocalFilePath.create(packageJsonPath))
//            }
//        }
//    }
}