package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class BrowserslistFileType private constructor() : LanguageFileType(BrowserslistLanguage.INSTANCE) {
    // TODO: 30.12.2020 Where name and description are used? Used in plugin.xml, but why?
    override fun getName(): String {
        return "Browserslist File"
    }

    override fun getDescription(): String {
        return "Browserslist config file"
    }

    override fun getDefaultExtension(): String {
        return "browserslistrc"
    }

    override fun getIcon(): Icon? {
        return BrowserslistIcons.FILE
    }

    companion object {
        val INSTANCE = BrowserslistFileType()
    }
}
