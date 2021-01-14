package com.github.aleksandrsl.intellijbrowserslist.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistSectionHeader
import com.intellij.lang.annotation.HighlightSeverity

class HighlightAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is BrowserslistSectionHeader) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(BrowserslistSyntaxHighlighter.SECTION_HEADER).create();
        }
    }
}