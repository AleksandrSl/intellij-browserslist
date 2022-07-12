package com.github.aleksandrsl.intellijbrowserslist

import com.github.aleksandrsl.intellijbrowserslist.psi.impl.BrowserslistSectionImpl
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.EditorLinePainter
import com.intellij.openapi.editor.LineExtensionInfo
import com.intellij.openapi.editor.colors.CodeInsightColors
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.markup.EffectType
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
import java.awt.Font

class BrowserslistLinePainter : EditorLinePainter() {

    override fun getLineExtensions(
        project: Project, file: VirtualFile, lineNumber: Int
    ): MutableCollection<LineExtensionInfo> {

        val psiManager: PsiManager = PsiManager.getInstance(project)
        val psiDocumentManager: PsiDocumentManager = PsiDocumentManager.getInstance(project)

//        val psiFile = psiManager.findFile(file)
//        if (psiFile?.fileType !is BrowserslistFileType) {
//            return
//        }
//        PsiTreeUtil.findChildrenOfType(root, BrowserslistSectionImpl::class.java).filter {
//            it.sectionQueries !== null
//        }
//        val document = psiDocumentManager.getDocument(psiFile)

        val coverage = BrowserslistLanguageService.getInstance(project).coverage("", arrayOf())?.get()
        val textAttributes = TextAttributes(
            EditorColorsManager.getInstance().globalScheme.getAttributes(DefaultLanguageHighlighterColors.LINE_COMMENT)?.effectColor,
            null,
            null,
            EffectType.BOXED,
            Font.ITALIC
        )
        return arrayListOf(
            LineExtensionInfo("coverage: $coverage", textAttributes),
        )
    }
}