package com.github.aleksandrsl.intellijbrowserslist.actions

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistCli
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable
import org.apache.xmlbeans.impl.store.Path
import java.nio.file.FileSystem
import java.nio.file.Paths


class UpdateDbAction: AnAction() {
    override fun update(e: AnActionEvent) {
        super.update(e)
    }

    override fun actionPerformed(event: AnActionEvent) {
        // Using the event, create and show a dialog
        // Using the event, create and show a dialog
        BrowserslistCli(Paths.get("/home/aleksandrsl/Projects/publications-demo/node_modules/browserslist/cli.js"), event.project!!).updateDb()
        val currentProject: Project? = event.project
        val dlgMsg = StringBuffer(event.presentation.text.toString() + " Selected!")
        val dlgTitle: String = event.presentation.description + "kek"
        // If an element is selected in the editor, add info about it.
        val nav: Navigatable? = event.getData(CommonDataKeys.NAVIGATABLE)
        if (nav != null) {
            dlgMsg.append(java.lang.String.format("\nSelected Element: %s", nav.toString()))
        }
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon())
    }
}
