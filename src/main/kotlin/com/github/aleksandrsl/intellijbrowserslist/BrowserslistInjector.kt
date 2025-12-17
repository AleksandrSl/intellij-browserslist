package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonProperty
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement

class BrowserslistInjector : LanguageInjectionContributor {
    override fun getInjection(element: PsiElement): Injection? {
        if (element.containingFile.name == "package.json"
            && element is JsonProperty
            && element.parent?.parent is JsonFile
            && element.name == "browserslist"
        ) {
            return SimpleInjection(BrowserslistLanguage.INSTANCE, "", "", null)
        }
        return null
    }
}
