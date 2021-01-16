package com.github.aleksandrsl.intellijbrowserslist.completion

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.DumbAware
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext

class BrowserslistKeywordCompletionContributor : CompletionContributor(), DumbAware {
    init {
        extend(
            CompletionType.BASIC,
            psiElement().andOr(
                psiElement().afterLeaf(psiElement(BrowserslistTypes.EOL)),
                psiElement().afterLeafSkipping(
                    psiElement().andOr(psiElement(BrowserslistTypes.INTEGER), psiElement().whitespace()),
                    psiElement(BrowserslistTypes.LAST)
                )
            ),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    result.addAllElements(TARGET_LOOKUP_ELEMENTS)
                }
            })
    }
}

val TARGET_NAMES = listOf(
    "Android",
    "Baidu",
    "BlackBerry", "bb",
    "Chrome",
    "ChromeAndroid", "and_chr",
    "Edge",
    "electron",
    "Explorer", "ie",
    "ExplorerMobile", "ie_mob",
    "Firefox", "ff", "fx",
    "FirefoxAndroid", "and_ff",
    "iOS", "ios_saf",
    "Node",
    "Opera",
    "OperaMini", "op_mini",
    "OperaMobile", "op_mob",
    "QQAndroid", "and_qq",
    "Safari",
    "Samsung",
    "UCAndroid", "and_uc",
    "kaios"
)

val TARGET_LOOKUP_ELEMENTS = TARGET_NAMES.map { LookupElementBuilder.create(it) }