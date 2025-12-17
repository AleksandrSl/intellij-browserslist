package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.json.psi.JsonArray
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonProperty
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionPerformer
import com.intellij.psi.ElementManipulators
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost

class BrowserslistInjectionPerformer : LanguageInjectionPerformer {
    override fun isPrimary(): Boolean {
        return true
    }

    override fun performInjection(
        registrar: MultiHostRegistrar, injection: Injection, context: PsiElement
    ): Boolean {
        val property = context as? JsonProperty ?: return false
        registrar.startInjecting(BrowserslistLanguage.INSTANCE)
        val value = property.value
        if (value is JsonArray) {
            processQueryExpressions(value, registrar)
        } else if (value is JsonObject) {
            value.propertyList.forEach { property ->
                registrar.addPlace(
                    "[",
                    "]\n",
                    property.nameElement as PsiLanguageInjectionHost,
                    ElementManipulators.getValueTextRange(property.nameElement)
                )
                val value = property.value
                if (value is JsonArray) {
                    processQueryExpressions(value, registrar)
                }
            }
        }
        registrar.doneInjecting()
        return true
    }
}

private fun processQueryExpressions(
    value: JsonArray, registrar: MultiHostRegistrar
) {
    value.valueList.forEach {
        if (it is JsonStringLiteral) {
            registrar.addPlace("", "\n", it as PsiLanguageInjectionHost, ElementManipulators.getValueTextRange(it))
        }
    }
}
