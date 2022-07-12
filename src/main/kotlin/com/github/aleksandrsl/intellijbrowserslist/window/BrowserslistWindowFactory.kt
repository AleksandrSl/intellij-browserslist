package com.github.aleksandrsl.intellijbrowserslist.window

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguageService
import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguageServiceImpl
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory


class BrowserslistWindowFactory : ToolWindowFactory {
    private val LOG: Logger = Logger.getInstance(BrowserslistWindowFactory::class.java)
    /**
     * Create the tool window content.
     *
     * @param project    current project
     * @param toolWindow current tool window
     */
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        LOG.warn("Initializing BrowserslistWindow")
        val myToolWindow = BrowserslistWindow(toolWindow, project);
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content: Content = contentFactory.createContent(myToolWindow.content, "", false)
        LOG.warn("Done initializing BrowserslistWindow")
        toolWindow.contentManager.addContent(content)
    }
}