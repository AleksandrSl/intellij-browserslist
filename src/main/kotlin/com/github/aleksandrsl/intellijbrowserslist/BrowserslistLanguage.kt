package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.lang.Language

// TODO: 30.12.2020 Could be an object, or will violate intelliJ API?
class BrowserslistLanguage: Language("browserslist") {

    companion object {
        val INSTANCE: BrowserslistLanguage = BrowserslistLanguage()
    }
}