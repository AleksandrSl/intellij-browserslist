package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task.Backgroundable
import com.intellij.openapi.project.Project
import com.intellij.util.io.systemIndependentPath
import java.nio.file.Path

class BrowserslistCli(private val path: Path, val project: Project) {
    fun updateDb() {
        var result = ""
        var errors = ""
        ProgressManager.getInstance().run(
            object : Backgroundable(project, "Updating db", true) {
                override fun run(indicator: ProgressIndicator) {
                    print("Running")
                    indicator.text = "Loading changes"
                    indicator.isIndeterminate = true
                    val process = GeneralCommandLine(path.systemIndependentPath)
                        .withWorkDirectory(project.basePath)
                        .withParameters("--update-db")
                        .createProcess()
                    process.inputStream.bufferedReader().use { result = it.readText() }
                    process.errorStream.bufferedReader().use { errors = it.readText() }
                    print(result)
                    if (process.exitValue() != 0) {
                        Notifications.Bus.notify(Notification(
                            "asdasd", "Failed to update db", errors, NotificationType.ERROR
                        ))
                    } else {
                        Notifications.Bus.notify(Notification(
                            "asdasd", "Db updated",result, NotificationType.INFORMATION
                        ))
                    }
                }
            }.setCancelText("Stop Loading")
        )
    }
}