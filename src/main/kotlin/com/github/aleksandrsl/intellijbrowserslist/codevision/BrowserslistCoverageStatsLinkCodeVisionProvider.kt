package com.github.aleksandrsl.intellijbrowserslist.codevision

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistBundle
import com.github.aleksandrsl.intellijbrowserslist.Section
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.codeVision.ui.model.ClickableTextCodeVisionEntry
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import java.net.URLEncoder

class BrowserslistCoverageStatsLinkCodeVisionProvider : BrowserslistCoverageStatsBaseCodeVisionProvider() {

    override val id: String = "browserslist.coverage.stats.link"
    override val name: String = "Browserslist Coverage Statistics Link"

    override val relativeOrderings: List<CodeVisionRelativeOrdering> = emptyList()


    private fun buildEntry(url: String): CodeVisionEntry = ClickableTextCodeVisionEntry(
        text = BrowserslistBundle.message("browserslist.codevision.see.stats.on.browsersl.ist.hint"),
        providerId = id,
        onClick = { _, _ -> BrowserUtil.browse(url) })

    override fun buildForQueries(
        file: PsiFile,
        queriesBySection: Collection<Section>
    ): List<Pair<TextRange, CodeVisionEntry>> {
        return queriesBySection.map {
            val encoded = URLEncoder.encode(it.queries, "UTF-8")
            val url = "https://browsersl.ist/#q=$encoded"
            it.textRange to buildEntry(url)
        }
    }
}
