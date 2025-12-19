package com.github.aleksandrsl.intellijbrowserslist.codevision

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistService
import com.github.aleksandrsl.intellijbrowserslist.Section
import com.github.aleksandrsl.intellijbrowserslist.SectionResult
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.codeVision.ui.model.ClickableTextCodeVisionEntry
import com.intellij.codeInsight.hints.settings.InlaySettingsConfigurable
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.options.ShowSettingsUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile


private val LOG = logger<BrowserslistSectionStatsCodeVisionProvider>()

/**
 * Shows browserslist statistics inline after section headers.
 */
class BrowserslistSectionStatsCodeVisionProvider : BrowserslistCoverageStatsBaseCodeVisionProvider() {
    override val id: String = "browserslist.coverage.stats"
    override val name: String = "Browserslist Coverage Statistics"

    override val relativeOrderings: List<CodeVisionRelativeOrdering> = listOf()

    override fun buildForQueries(
        file: PsiFile,
        queriesBySection: Collection<Section>
    ): List<Pair<TextRange, CodeVisionEntry>> {
        val browserslistResults =
            BrowserslistService.getInstance(file.project).getFileResult(file.virtualFile, queriesBySection)
                ?: return emptyList()

        return browserslistResults.mapNotNull { result ->
            when (result) {
                is SectionResult.Success -> {
                    val entry = buildEntry("${result.result.coverage.global}% in global", file.project)
                    val range = queriesBySection.firstOrNull { it.name == result.name }?.textRange
                    if (range == null) {
                        LOG.warn("Section ${result.name} not found in file ${file.virtualFile.path}")
                        return@mapNotNull null
                    }
                    range to entry
                }

                else -> null
            }
        }
    }

    private fun buildEntry(text: String, project: Project): CodeVisionEntry = ClickableTextCodeVisionEntry(
        text = text,
        providerId = id,
        onClick = { _, _ ->
            ShowSettingsUtil.getInstance().showSettingsDialog(project, InlaySettingsConfigurable::class.java)
        })
}
