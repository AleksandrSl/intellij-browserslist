package com.github.aleksandrsl.intellijbrowserslist.parser

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes.IDENTIFIER
import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.openapi.diagnostic.logger

val countryCodeRegex = Regex("(alt-)?[a-z]{2}", option = RegexOption.IGNORE_CASE)

private val LOG = logger<BrowserslistParserUtil>()

object BrowserslistParserUtil : GeneratedParserUtilBase() {

    /**
     * Parses stats reference patterns:
     * - "my stats"
     * - "{IDENTIFIER} stats"
     * - "(alt-)?{2 letter code}" (country codes like "us", "alt-us")
     */
    @JvmStatic
    fun parseStats(builder: PsiBuilder, level: Int): Boolean {
        if (!recursion_guard_(builder, level, "parseStats")) return false

        var result = parseMyStats(builder)
        if (!result) result = parseCountryCodeOrIdentifierStats(builder, level + 1)
        return result
    }

    private fun parseMyStats(builder: PsiBuilder): Boolean {
        return consumeToken(builder, "my", false) && consumeToken(builder, "stats", false)
    }

    private fun parseCountryCodeOrIdentifierStats(builder: PsiBuilder, level: Int): Boolean {
        if (!recursion_guard_(builder, level, "parseStats_codeOrIdentifier")) return false
        val text = builder.tokenText ?: return false

        addVariant(builder, "xx or alt-xx (country code)")
        if (countryCodeRegex.matchEntire(text) != null) {
            builder.advanceLexer()
            return true
        } else {
            return consumeToken(builder, IDENTIFIER) && consumeToken(builder, "stats", false)
        }
    }
}
