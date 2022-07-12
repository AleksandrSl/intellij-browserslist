package com.github.aleksandrsl.intellijbrowserslist.window

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistFileType
import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguageService
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistQueryExpression
import com.github.aleksandrsl.intellijbrowserslist.psi.impl.BrowserslistQueryExpressionImpl
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.GlobalSearchScope.projectScope
import com.intellij.psi.search.ProjectScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.ui.layout.panel
import javax.swing.JPanel


class BrowserslistWindow(toolWindow: ToolWindow, private val project: Project) {
    private val LOG: Logger = Logger.getInstance(BrowserslistWindow::class.java)

    var content: JPanel? = null

    init {
        content = panel {
            row {
                label("No browserslist files found")
            }
        }
        val contentScope = ProjectScope.getContentScope(project)
        val scope = contentScope.intersectWith(GlobalSearchScope.notScope(ProjectScope.getLibrariesScope(project)))
        val files = FileTypeIndex.getFiles(BrowserslistFileType.INSTANCE, scope)
        LOG.warn(files.map { it.canonicalPath }.joinToString(","))
        if (!files.isEmpty()) {
            val psiManager: PsiManager = PsiManager.getInstance(project)
            val psiFile = psiManager.findFile(files.toList()[0])
            val queryExpressions = PsiTreeUtil.findChildrenOfType(psiFile, BrowserslistQueryExpressionImpl::class.java).toList()
            val queryExpressions2 = PsiTreeUtil.findChildrenOfType(psiFile, BrowserslistQueryExpressionImpl::class.java).toList()
            val coverage = BrowserslistLanguageService.getInstance(project).coverage("", queryExpressions.map { it.text }.toTypedArray())?.get()?.result
            LOG.warn("Coverage: $coverage")
            LOG.warn(queryExpressions.map { it.text }.joinToString(","))
            LOG.warn(queryExpressions2.map { it.text }.joinToString(","))
            content = panel {
                row {
                    label("Coverage: $coverage%")
                }
            }
        }

    }
}