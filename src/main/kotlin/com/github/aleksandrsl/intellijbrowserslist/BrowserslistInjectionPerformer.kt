package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.json.psi.JsonArray
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonProperty
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionPerformer
import com.intellij.openapi.util.TextRange
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
        val value = property.value
        val injections = mutableListOf<InjectionEntry>()
        if (value is JsonArray) {
            injections.addAll(processQueryExpressions(value))
        } else if (value is JsonObject) {
            value.propertyList.forEach { property ->
                injections.add(
                    InjectionEntry.SectionHeader(
                        property.nameElement as PsiLanguageInjectionHost,
                        ElementManipulators.getValueTextRange(property.nameElement)
                    )
                )
                val value = property.value
                if (value is JsonArray) {
                    injections.addAll(processQueryExpressions(value))
                }
            }
        }
        if (injections.isEmpty()) return false

        registrar.startInjecting(BrowserslistLanguage.INSTANCE)
        injections.forEach {
            when (it) {
                is InjectionEntry.SectionHeader -> registrar.addPlace("[", "]\n", it.host, it.range)
                is InjectionEntry.QueryExpression -> registrar.addPlace(null, "\n", it.host, it.range)
            }
        }
        registrar.doneInjecting()
        return true
    }
}

private fun processQueryExpressions(
    value: JsonArray
): List<InjectionEntry> {
    return value.valueList.mapNotNull {
        if (it is JsonStringLiteral) {
            InjectionEntry.QueryExpression(it as PsiLanguageInjectionHost, ElementManipulators.getValueTextRange(it))
        } else {
            null
        }
    }
}


sealed class InjectionEntry(
    val host: PsiLanguageInjectionHost, val range: TextRange
) {
    class SectionHeader(host: PsiLanguageInjectionHost, range: TextRange) : InjectionEntry(host, range)
    class QueryExpression(host: PsiLanguageInjectionHost, range: TextRange) : InjectionEntry(host, range)
}

