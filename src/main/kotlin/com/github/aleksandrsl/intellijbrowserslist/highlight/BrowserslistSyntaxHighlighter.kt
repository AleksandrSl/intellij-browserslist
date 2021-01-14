package com.github.aleksandrsl.intellijbrowserslist.highlight

import com.github.aleksandrsl.intellijbrowserslist.lexer.BrowserslistLexerAdapter
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.EMPTY_ARRAY
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType


class BrowserslistSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return BrowserslistLexerAdapter()
    }



    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        print(tokenType)
        return when (tokenType) {
            BrowserslistTypes.AND,
            BrowserslistTypes.OR -> {
                OPERATOR_KEYS
            }
            BrowserslistTypes.COMMENT -> {
                COMMENT_KEYS
            }
            BrowserslistTypes.IDENTIFIER,
            BrowserslistTypes.FEATURE -> {
                IDENTIFIER_KEYS
            }
            TokenType.BAD_CHARACTER -> {
                BAD_CHAR_KEYS
            }
            else -> {
                EMPTY_KEYS
            }
        }
    }

    companion object {
        val OPERATOR: TextAttributesKey =
            createTextAttributesKey("BROWSERSLIST_OPERATOR", DefaultLanguageHighlighterColors.KEYWORD)
        val IDENTIFIER: TextAttributesKey = createTextAttributesKey("BROWSERSLIST_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val COMMENT: TextAttributesKey =
            createTextAttributesKey("BROWSERSLIST_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER: TextAttributesKey =
            createTextAttributesKey("BROWSERSLIST_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = EMPTY_ARRAY
    }
}