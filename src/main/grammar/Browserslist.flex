package com.github.aleksandrsl.intellijbrowserslist.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes;
import com.intellij.psi.TokenType;

%%

%class BrowserslistLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
LBRACKET="["
RBRACKET="]"
WHITE_SPACE=[\ \n\t\f]
//FIRST_IDENTIFIER_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
//INDENTIFIER_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
IDENTIFIER=\S+
END_OF_LINE_COMMENT=("#")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "
COMPARE=>=?|<=?
NUMBER=\d*\.?\d+
// Why allow 29.%?
PERCENT={NUMBER}%
STATS=(my\s+stats)|(\S+\s+stats)|((alt-)?\w\w)|{IDENTIFIER}

%state WAITING_VALUE

%%

<YYINITIAL> "in"                           { yybegin(YYINITIAL); return BrowserslistTypes.IN; }
//<YYINITIAL> "last"                           { yybegin(YYINITIAL); return BrowserslistTypes.LAST; }
//<YYINITIAL> "major"                           { yybegin(YYINITIAL); return BrowserslistTypes.MAJOR; }
//<YYINITIAL> "versions"                           { yybegin(YYINITIAL); return BrowserslistTypes.VERSION; }
//<YYINITIAL> "unreleased"                          { yybegin(YYINITIAL); return BrowserslistTypes.UNRELEASED; }
//<YYINITIAL> "years"                          { yybegin(YYINITIAL); return BrowserslistTypes.YEARS; }
//<YYINITIAL> "since"                          { yybegin(YYINITIAL); return BrowserslistTypes.SINCE; }
//<YYINITIAL> "supports"                          { yybegin(YYINITIAL); return BrowserslistTypes.SUPPORTS; }
//<YYINITIAL> "cover"                          { yybegin(YYINITIAL); return BrowserslistTypes.COVER; }
<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return BrowserslistTypes.COMMENT; }
<YYINITIAL> {COMPARE}                           { yybegin(YYINITIAL); return BrowserslistTypes.COMPARE; }
<YYINITIAL> {PERCENT}                           { yybegin(YYINITIAL); return BrowserslistTypes.PERCENT; }
<YYINITIAL> {STATS}                           { yybegin(YYINITIAL); return BrowserslistTypes.STATS; }
<YYINITIAL> {IDENTIFIER}   { yybegin(YYINITIAL); return BrowserslistTypes.IDENTIFIER; }


{CRLF}+ { yybegin(YYINITIAL); return BrowserslistTypes.CRLF; }
{WHITE_SPACE}+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }