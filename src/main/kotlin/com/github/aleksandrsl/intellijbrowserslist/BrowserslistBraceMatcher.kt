package com.github.aleksandrsl.intellijbrowserslist

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class BrowserslistBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> {
        return arrayOf(BracePair(BrowserslistTypes.LBRACKET, BrowserslistTypes.RBRACKET, false))
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}