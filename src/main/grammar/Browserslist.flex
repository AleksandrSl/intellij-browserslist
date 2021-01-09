package com.github.aleksandrsl.intellijbrowserslist.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes;
import com.intellij.psi.TokenType;

%%

%{
  public BrowserslistLexer() {
    this((java.io.Reader)null);
  }
%}

%class BrowserslistLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

EOL=\R
LBRACKET="["
RBRACKET="]"
WHITE_SPACE=[\ \n\t\f]
IDENTIFIER=\S+
END_OF_LINE_COMMENT=("#")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "
COMPARE=>=?|<=?
// Maybe it's not for lexer and parser to discern integer from float
INTEGER=\d+
FLOAT=\d*\.?\d+
// Why allow 29.%?
PERCENT={FLOAT}%
STATS=(my\s+stats)|(\S+\s+stats)|((alt-)?\w\w)|{IDENTIFIER}

%%

<YYINITIAL> {
    "in"                           { return BrowserslistTypes.IN; }
    "last"                           { return BrowserslistTypes.LAST; }
    "major"                           { return BrowserslistTypes.MAJOR; }
    "versions"                           { return BrowserslistTypes.VERSIONS; }
    //"unreleased"                          { return BrowserslistTypes.UNRELEASED; }
    //"years"                          { return BrowserslistTypes.YEARS; }
    //"since"                          { return BrowserslistTypes.SINCE; }
    //"supports"                          { return BrowserslistTypes.SUPPORTS; }
    //"cover"                          { return BrowserslistTypes.COVER; }
    "defaults"                          { return BrowserslistTypes.DEFAULTS; }
    {END_OF_LINE_COMMENT}                           { return BrowserslistTypes.COMMENT; }
    {COMPARE}                           { return BrowserslistTypes.COMPARE; }
    {INTEGER}                           { return BrowserslistTypes.INTEGER; }
    {PERCENT}                           { return BrowserslistTypes.PERCENT; }
    {STATS}                           { return BrowserslistTypes.STATS; }
    {IDENTIFIER}   { return BrowserslistTypes.IDENTIFIER; }


    {EOL}                       { return BrowserslistTypes.EOL; }
    {WHITE_SPACE}+                                     { return TokenType.WHITE_SPACE; }
}

[^]                                                         { return TokenType.BAD_CHARACTER; }