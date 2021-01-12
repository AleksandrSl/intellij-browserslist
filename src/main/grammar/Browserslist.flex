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
WHITE_SPACE=[\ \t\f]
IDENTIFIER=[\S--,]+
END_OF_LINE_COMMENT=("#")[^\r\n]*
COMPARE=>=?|<=?
// Maybe it's not for lexer and parser to discern integer from float
INTEGER=\d+
FLOAT=\d*\.?\d+
PERCENT={FLOAT}%
STATS=(my\s+stats)|({IDENTIFIER}\s+stats)|((alt-)?\w\w)
FIREFOX=Firefox|fx|ff|FirefoxAndroid|and_ff
SAFARI=Safari|iOS|ios_saf
EXPLORER=Explorer|ie|ExplorerMobile|ie_mob
BLACKBERRY=BlackBerry|bb
OPERA=Opere|OperaMini|op_mini|OperaMobile|op_mob
CHROME=Chrome|ChromeAndroid|and_chr
BROWSER={FIREFOX}|{CHROME}|{SAFARI}|{EXPLORER}|{BLACKBERRY}|{OPERA}|Android|Baidu|Edge|Samsung|UCAndroid|and_uc|QQandroid|and_qq|UCAndroid|and_uc|kaios
TARGET={BROWSER}|electron|[Nn]ode|[Pp]hantom[jJ][sS]
TIME=\d+(-\d+){1,2}
FEATURE=[-\w]+

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
// What is TP?

// It will be generic for now. Find a way to show errors
TARGET_VERSION=(tp|[\d.]+|all|esr|ESR)
TARGET_VERSIONS_RANGE={TARGET_VERSION}\s*-\s*{TARGET_VERSION}


%state TARGET
%state SUPPORTS

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
    "supports"                          { yybegin(SUPPORTS); return BrowserslistTypes.SUPPORTS; }
    "cover"                          { return BrowserslistTypes.COVER; }
    "defaults"                          { return BrowserslistTypes.DEFAULTS; }
    "maintained"                        { return BrowserslistTypes.MAINTAINED_NODE_VERSIONS; }
    "current"                           { return BrowserslistTypes.CURRENT_NODE_VERSION; }
    "extends"                           { return BrowserslistTypes.EXTENDS; }
    or|","                                { return BrowserslistTypes.OR; }
    "and"                                { return BrowserslistTypes.AND; }
    "not"                                { return BrowserslistTypes.NOT; }
    {TARGET}                            { yybegin(TARGET); return BrowserslistTypes.TARGET; }
    {END_OF_LINE_COMMENT}                           { return BrowserslistTypes.COMMENT; }
    {COMPARE}                           { return BrowserslistTypes.COMPARE; }
    {TIME}                              { return BrowserslistTypes.TIME; }
    {INTEGER}                           { return BrowserslistTypes.INTEGER; }
    {FLOAT}                             { return BrowserslistTypes.FLOAT; }
    {PERCENT}                           { return BrowserslistTypes.PERCENT; }
    {STATS}                           { return BrowserslistTypes.STATS; }
    {IDENTIFIER}                      { return BrowserslistTypes.IDENTIFIER; }


    {EOL}                       { return BrowserslistTypes.EOL; }
    {WHITE_SPACE}+                                     { return TokenType.WHITE_SPACE; }
}

<TARGET> {
    "major"                           { yybegin(YYINITIAL); return BrowserslistTypes.MAJOR; }
    versions?                           { yybegin(YYINITIAL); return BrowserslistTypes.VERSIONS; }
    or|,                                { yybegin(YYINITIAL); return BrowserslistTypes.OR; }
    "and"                                { yybegin(YYINITIAL); return BrowserslistTypes.AND; }
    "not"                                { yybegin(YYINITIAL); return BrowserslistTypes.NOT; }
    {COMPARE}                           { return BrowserslistTypes.COMPARE; }
    {TARGET_VERSIONS_RANGE}                  { yybegin(YYINITIAL); return BrowserslistTypes.TARGET_VERSIONS_RANGE; }
    // `all` and `esr` will not be parsed as feature
    // How am i supposed to discern integer from version?
    {TARGET_VERSION}                  { yybegin(YYINITIAL); return BrowserslistTypes.TARGET_VERSION; }
    {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return BrowserslistTypes.COMMENT; }
    {EOL}                       { yybegin(YYINITIAL); return BrowserslistTypes.EOL; }
    {WHITE_SPACE}+                                     { return TokenType.WHITE_SPACE; }
}

<SUPPORTS> {
    // Maybe abstract identifier should be used and meaning added after parsing level, or different states used
    {FEATURE}                         { yybegin(YYINITIAL); return BrowserslistTypes.FEATURE; }
    {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return BrowserslistTypes.COMMENT; }
    {EOL}                             { yybegin(YYINITIAL); return BrowserslistTypes.EOL; }
    {WHITE_SPACE}+                                     { return TokenType.WHITE_SPACE; }
}

[^]                                                         { return TokenType.BAD_CHARACTER; }