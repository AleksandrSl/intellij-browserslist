package com.github.aleksandrsl.intellijbrowserslist.psi

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistFileType
import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

class BrowserslistFile(viewProvider: @NotNull FileViewProvider) :
    PsiFileBase(viewProvider, BrowserslistLanguage.INSTANCE) {

    override fun getFileType(): FileType {
        return BrowserslistFileType.INSTANCE
    }

    override fun toString(): String {
        return "Browserslist file"
    }

}