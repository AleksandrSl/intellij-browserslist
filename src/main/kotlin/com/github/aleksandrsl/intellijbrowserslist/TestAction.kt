package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.lang.javascript.linter.JSLinterFixAction
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable

class TestAction: AnAction() {

    override fun update(e: AnActionEvent) {
        // Using the event, evaluate the context,
        // and enable or disable the action.
        e.presentation.isEnabledAndVisible = true
    }

    override fun actionPerformed(e: AnActionEvent) {
        // Using the event, create and show a dialog
        val currentProject: Project? = e.project
        val message: StringBuilder = StringBuilder(e.presentation.text + " Selected!")
        // If an element is selected in the editor, add info about it.
        val selectedElement: Navigatable? = e.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement)
        }
        if (currentProject != null) {
            TestTask.start(currentProject)
        }
//        val title: String = e.presentation.description
//        Messages.showMessageDialog(
//            currentProject,
//            message.toString(),
//            title,
//            Messages.getInformationIcon()
//        )
    }
}