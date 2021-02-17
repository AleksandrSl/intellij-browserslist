package com.github.aleksandrsl.intellijbrowserslist.psi

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguage
import com.intellij.psi.tree.IElementType

class BrowserslistTokenType(debugName: String) :
    IElementType(debugName, BrowserslistLanguage.INSTANCE) {

    override fun toString(): String {
        return "BrowserslistTokenType.${super.toString()}"
    }
}
