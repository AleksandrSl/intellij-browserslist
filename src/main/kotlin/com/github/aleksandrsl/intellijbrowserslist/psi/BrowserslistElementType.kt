package com.github.aleksandrsl.intellijbrowserslist.psi

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguage
import com.intellij.psi.tree.IElementType

class BrowserslistElementType(debugName: String) :
    IElementType(debugName, BrowserslistLanguage.INSTANCE) {
}