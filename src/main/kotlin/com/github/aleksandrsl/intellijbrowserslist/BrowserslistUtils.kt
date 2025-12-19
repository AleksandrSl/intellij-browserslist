package com.github.aleksandrsl.intellijbrowserslist

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistFile
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistSection
import com.intellij.json.psi.JsonArray
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.psi.util.PsiTreeUtil

fun joinQueries(queries: Collection<String>): String {
    return queries.map { it.trim() }.filter { it.isNotEmpty() }.joinToString(", ")
}

fun collectQueriesBySection(file: BrowserslistFile): List<Section> {
    val sections = PsiTreeUtil.getChildrenOfTypeAsList(file, BrowserslistSection::class.java)

    return sections.mapNotNull { section ->
        val queries = joinQueries(section.queryExpressionList.map { it.text })
        // TODO (AleksandrSl 19/12/2025): If there are same named section we will calculate results incorrectly
        // TODO (AleksandrSl 19/12/2025): Support custom stats
        if (queries.isBlank()) null else Section(
            SectionName(section.sectionName),
            queries,
            section.sectionHeader?.textRange ?: section.textRange
        )
    }
}

fun collectQueriesBySection(file: JsonFile): List<Section> {
    val queriesBySection = ArrayList<Section>()
    val rootObject = file.topLevelValue as? JsonObject ?: return queriesBySection
    val prop = rootObject.findProperty("browserslist") ?: return queriesBySection

    when (val value = prop.value) {
        is JsonArray -> {
            prop.nameElement.textRange?.let { range ->
                val queries = joinQueries(value.valueList.mapNotNull { (it as? JsonStringLiteral)?.value })
                if (queries.isNotBlank()) {
                    queriesBySection.add(
                        Section(
                            SectionName(prop.nameElement.text),
                            queries,
                            range,
                        )
                    )
                }
            }
        }

        is JsonObject -> {
            // Each nested property is a section
            for (sectionProp in value.propertyList) {
                val secValue = sectionProp.value
                if (secValue is JsonArray) {
                    sectionProp.nameElement.textRange?.let { range ->
                        val queries = joinQueries(secValue.valueList.mapNotNull { (it as? JsonStringLiteral)?.value })
                        if (queries.isNotBlank()) {
                            queriesBySection.add(
                                Section(
                                    SectionName(prop.nameElement.text),
                                    queries,
                                    range,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
    return queriesBySection
}
