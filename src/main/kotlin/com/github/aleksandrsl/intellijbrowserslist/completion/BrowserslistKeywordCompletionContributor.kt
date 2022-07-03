package com.github.aleksandrsl.intellijbrowserslist.completion

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
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
            }
        )
    }
}

val TARGET_NAMES = listOf(
    "Android", "android",
    "Baidu", "baidu",
    "BlackBerry", "blackberry", "bb",
    "Chrome", "chrome",
    "ChromeAndroid", "chromeandroid", "and_chr",
    "Edge", "edge",
    "electron",
    "Explorer", "explorer", "ie",
    "ExplorerMobile", "explorermobile", "ie_mob",
    "Firefox", "firefox", "ff", "fx",
    "FirefoxAndroid", "firefoxandroid", "and_ff",
    "iOS", "ios", "ios_saf",
    "Node", "node",
    "Opera", "opera",
    "OperaMini", "operamini", "op_mini",
    "OperaMobile", "operamobile", "op_mob",
    "QQAndroid", "qqandroid", "and_qq",
    "Safari", "safari",
    "Samsung", "samsung",
    "UCAndroid", "ucandroid", "and_uc",
    "kaios"
)

val TARGET_LOOKUP_ELEMENTS = TARGET_NAMES.map { LookupElementBuilder.create(it) }
