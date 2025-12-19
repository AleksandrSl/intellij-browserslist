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
%caseless
%function advance
%type IElementType

EOL=\R
WHITE_SPACE=[\ \t\f]
IDENTIFIER=[\S--,\]\[>=<]+
END_OF_LINE_COMMENT=#[^\r\n]*
COMPARE=>=?|<=?
// Maybe it's not for lexer and parser to discern integer from float
INTEGER=\d+
FLOAT=\d*\.?\d+
PERCENT={FLOAT}%
FIREFOX=firefox|fx|ff|FirefoxAndroid|and_ff
SAFARI=safari|iOS|ios_saf
EXPLORER=explorer|ie|ExplorerMobile|ie_mob
BLACKBERRY=BlackBerry|bb
OPERA=opera|OperaMini|op_mini|OperaMobile|op_mob
CHROME=chrome|ChromeAndroid|and_chr
BROWSER={FIREFOX}|{CHROME}|{SAFARI}|{EXPLORER}|{BLACKBERRY}|{OPERA}|android|baidu|edge|samsung|UCAndroid|and_uc|QQAndroid|and_qq|kaios
TARGET={BROWSER}|electron|node|phantomjs
TIME=\d+(-\d+){1,2}

/*
electron\s+([\d.]+)\s*-\s*([\d.]+)
electron\s*(>=?|<=?)\s*([\d.]+)
electron\s+([\d.]+)

node\s+([\d.]+)\s*-\s*([\d.]+)
node\s*(>=?|<=?)\s*([\d.]+)
node\s+(\d+(\.\d+)?(\.\d+)?)
maintained\s+node\s+versions
current\s+node

(firefox|ff|fx)\s+esr

(operamini|op_mini)\s+all

phantomjs\s+1.9 phantomjs\s+2.1

(\w+)\s+([\d.]+)\s*-\s*([\d.]+)
(\w+)\s*(>=?|<=?)\s*([\d.]+)
(\w+)\s+(tp|[\d.]+)
*/

// Why not node current? This will be consistent
// Does phantomjs allowed in other queries? I think not
// What is TP? - technical preview

// It will be generic for now. Find a way to show errors
TARGET_VERSION=(tp|[\d.]+|all|esr|ESR)
TARGET_VERSIONS_RANGE={TARGET_VERSION}\s*-\s*{TARGET_VERSION}

%state TARGET

%%

or|,                                 { yybegin(YYINITIAL); return BrowserslistTypes.OR; }
"and"                                { yybegin(YYINITIAL); return BrowserslistTypes.AND; }
"not"                                { yybegin(YYINITIAL); return BrowserslistTypes.NOT; }

<YYINITIAL> {
    "["                              { return BrowserslistTypes.LBRACKET; }
    "]"                              { return BrowserslistTypes.RBRACKET; }
    {TARGET}                         { yybegin(TARGET); return BrowserslistTypes.TARGET; }
    {END_OF_LINE_COMMENT}            { return BrowserslistTypes.COMMENT; }
    {COMPARE}                        { return BrowserslistTypes.COMPARE; }
    {TIME}                           { return BrowserslistTypes.TIME; }
    {INTEGER}                        { return BrowserslistTypes.INTEGER; }
    {FLOAT}                          { return BrowserslistTypes.FLOAT; }
    {PERCENT}                        { return BrowserslistTypes.PERCENT; }
    {IDENTIFIER}                     { return BrowserslistTypes.IDENTIFIER; }
}

<TARGET> {
    {COMPARE}                        { return BrowserslistTypes.COMPARE; }
    {TARGET_VERSIONS_RANGE}          { yybegin(YYINITIAL); return BrowserslistTypes.TARGET_VERSIONS_RANGE; }
    // `all` and `esr` will not be parsed as feature
    // How am i supposed to discern integer from version?
    {TARGET_VERSION}                 { yybegin(YYINITIAL); return BrowserslistTypes.TARGET_VERSION; }
    {IDENTIFIER}                     { yybegin(YYINITIAL); return BrowserslistTypes.IDENTIFIER; }
}

{END_OF_LINE_COMMENT}                { yybegin(YYINITIAL); return BrowserslistTypes.COMMENT; }
{EOL}                                { yybegin(YYINITIAL); return BrowserslistTypes.EOL; }
{WHITE_SPACE}+                       { return TokenType.WHITE_SPACE; }

[^]                                  { return TokenType.BAD_CHARACTER; }
