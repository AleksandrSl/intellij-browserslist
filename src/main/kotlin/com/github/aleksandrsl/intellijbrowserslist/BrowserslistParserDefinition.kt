package com.github.aleksandrsl.intellijbrowserslist

import com.github.aleksandrsl.intellijbrowserslist.lexer.BrowserslistLexerAdapter
import com.github.aleksandrsl.intellijbrowserslist.parser.BrowserslistParser
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistFile
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class BrowserslistParserDefinition : ParserDefinition {

    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(BrowserslistTypes.COMMENT)

    val FILE = IFileElementType(BrowserslistLanguage.INSTANCE)

    override fun createLexer(project: Project?): Lexer {
        return BrowserslistLexerAdapter()
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project?): PsiParser {
        return BrowserslistParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider?): PsiFile? {
        return viewProvider?.let { BrowserslistFile(it) }
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): SpaceRequirements? {
        return SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return BrowserslistTypes.Factory.createElement(node)
    }
}
