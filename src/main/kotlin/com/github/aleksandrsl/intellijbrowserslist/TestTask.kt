package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.javascript.nodejs.util.NodePackage
import com.intellij.lang.javascript.service.JSLanguageServiceUtil
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.progress.impl.BackgroundableProcessIndicator
import com.intellij.openapi.ui.Messages
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project as IdeaProject

class TestTask private constructor(
    private val ideaProject: IdeaProject
) : Task.Backgroundable(ideaProject, "Test task", true) {
    private val LOG: Logger = Logger.getInstance(TestTask::class.java)
    private val indicator: ProgressIndicator = Indicator(this)

    override fun run(indicator: ProgressIndicator) {
        LOG.warn(ideaProject.basePath)
        val browserslistPackage = NodePackage("node_modules/browserslist")
        val res = BrowserslistLanguageService.getInstance(ideaProject).coverage("", browserslistPackage)?.get()
//        val res = JSLanguageServiceUtil.awaitFuture(
//            BrowserslistLanguageService.getInstance(ideaProject).coverage("", browserslistPackage)
//        )
        LOG.warn(
            (res == null).toString()
        )
        LOG.warn(
            res?.toString()
        )
        LOG.warn(
            res?.result?.toString()
        )
        LOG.warn(
            res?.error
        )
//        LOG.warn("node ${ideaProject.basePath}/node_modules/browserslist/cli.js --coverage \"> 1%\"".runCommand(File(ideaProject.basePath!!)))
//        LOG.info(ideaProject.basePath)
//        Messages.showMessageDialog(
//            ideaProject,
//            ideaProject.basePath,
//            "TestTask",
//            Messages.getInformationIcon()
//        )
//        "node node_modules/browserslist/cli.js --coverage \"> 1%\""
    }

    private fun terminate() {
    }

    private class Indicator(private val task: TestTask) : BackgroundableProcessIndicator(task) {

        override fun onRunningChange() {
            if (this.isCanceled) {
                task.terminate()
            }
        }

    }

    companion object {
        fun start(ideaProject: IdeaProject) {
//            componentFactory.makeAnnotationManager(ideaProject).hide()
            val task = TestTask(ideaProject)
            ProgressManager.getInstance().runProcessWithProgressAsynchronously(task, task.indicator)
        }
    }
}

fun String.runCommand(workingDir: File): String? {
    try {
        val parts = this.split("\\s".toRegex())
        val proc = ProcessBuilder(*parts.toTypedArray())
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        proc.waitFor(60, TimeUnit.MINUTES)
        return proc.inputStream.bufferedReader().readText()
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
}