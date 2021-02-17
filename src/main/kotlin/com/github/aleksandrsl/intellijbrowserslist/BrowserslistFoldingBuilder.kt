package com.github.aleksandrsl.intellijbrowserslist

import com.github.aleksandrsl.intellijbrowserslist.psi.impl.BrowserslistSectionImpl
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.map2Array

class BrowserslistFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        val sections = PsiTreeUtil.findChildrenOfType(root, BrowserslistSectionImpl::class.java).filter {
            it.eolSeparatedItems !== null
        }

        return sections.map2Array {
            FoldingDescriptor(
                it.node,
                it.eolSeparatedItems!!.textRange,
                FoldingGroup.newGroup(it.sectionHeader.text)
            )
        }
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}
