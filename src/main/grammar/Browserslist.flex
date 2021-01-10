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
PERCENT={FLOAT}%
STATS=(my\s+stats)|(\S+\s+stats)|((alt-)?\w\w)|{IDENTIFIER}
FIREFOX=Firefox|fx|ff|FirefoxAndroid|and_ff
SAFARI=Safari|iOS|ios_saf
EXPLORER=Explorer|ie|ExplorerMobile|ie_mob
BLACKBERRY=BlackBerry|bb
OPERA=Opere|OperaMini|op_mini|OperaMobile|op_mob
CHROME=Chrome|ChromeAndroid|and_chr
BROWSER={FIREFOX}|{CHROME}|{SAFARI}|{EXPLORER}|{BLACKBERRY}|{OPERA}|Android|Baidu|Edge|Samsung|UCAndroid|and_uc|QQandroid|and_qq|UCAndroid|and_uc|kaios
TARGET={BROWSER}|electron|Node
TIME=\d+(-\d+){1,2}

%%

<YYINITIAL> {
    "in"                           { return BrowserslistTypes.IN; }
    "last"                           { return BrowserslistTypes.LAST; }
    "major"                           { return BrowserslistTypes.MAJOR; }
    versions?                           { return BrowserslistTypes.VERSIONS; }
    "unreleased"                          { return BrowserslistTypes.UNRELEASED; }
    "dead"                          { return BrowserslistTypes.DEAD; }
    "years"                          { return BrowserslistTypes.YEARS; }
    "since"                          { return BrowserslistTypes.SINCE; }
    //"supports"                          { return BrowserslistTypes.SUPPORTS; }
    "cover"                          { return BrowserslistTypes.COVER; }
    "defaults"                          { return BrowserslistTypes.DEFAULTS; }
    {TARGET}                           { return BrowserslistTypes.TARGET; }
    {END_OF_LINE_COMMENT}                           { return BrowserslistTypes.COMMENT; }
    {COMPARE}                           { return BrowserslistTypes.COMPARE; }
    {TIME}                              { return BrowserslistTypes.TIME; }
    {INTEGER}                           { return BrowserslistTypes.INTEGER; }
    {FLOAT}                             { return BrowserslistTypes.FLOAT; }
    {PERCENT}                           { return BrowserslistTypes.PERCENT; }
    {STATS}                           { return BrowserslistTypes.STATS; }
    {IDENTIFIER}   { return BrowserslistTypes.IDENTIFIER; }


    {EOL}                       { return BrowserslistTypes.EOL; }
    {WHITE_SPACE}+                                     { return TokenType.WHITE_SPACE; }
}

[^]                                                         { return TokenType.BAD_CHARACTER; }