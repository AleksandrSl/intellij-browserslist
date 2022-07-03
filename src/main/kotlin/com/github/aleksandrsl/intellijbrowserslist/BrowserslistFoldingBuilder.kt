package com.github.aleksandrsl.intellijbrowserslist

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistQuery
import com.github.aleksandrsl.intellijbrowserslist.psi.impl.BrowserslistSectionImpl
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.descendantsOfType
import com.intellij.util.containers.map2Array

class BrowserslistFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        val sections = PsiTreeUtil.findChildrenOfType(root, BrowserslistSectionImpl::class.java).filter {
            it.sectionQueries !== null
        }

        return sections.map2Array {
            FoldingDescriptor(
                it.node,
                // Last element is usually EOL, if we don't skip it the next line is glued to the folding text.
                // Still could be improved on the parser side. We don't want to include comments
                // that are not followed by any query to the section. But this
                // could require look ahead. Which is not great or maybe possible.
                it.sectionQueries!!.textRange.grown(-1),
                FoldingGroup.newGroup(it.sectionHeader.text)
            )
        }
    }

    override fun getPlaceholderText(node: ASTNode): String {
        val psi = node.psi
        if (psi is BrowserslistSectionImpl) {
            val queriesNumber = psi.sectionQueries?.descendantsOfType<BrowserslistQuery>()?.count() ?: return "..."
            val query = if (queriesNumber != 1) "queries" else "query"
            return "... $queriesNumber $query"
        }
        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}
