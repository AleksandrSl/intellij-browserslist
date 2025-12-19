// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BrowserslistParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return browserslistFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(FULL_SECTION, HEADLESS_SECTION),
    create_token_set_(AND_EXPRESSION, NOT_EXPRESSION, OR_EXPRESSION, QUERY_EXPRESSION,
      SIMPLE_EXPRESSION),
    create_token_set_(BASELINE_QUERY, DEAD_QUERY, DEFAULTS_QUERY, EXTENDS_QUERY,
      LAST_QUERY, QUERY, STATS_QUERY, SUPPORTS_QUERY,
      TARGET_QUERY, TIME_QUERY, UNRELEASED_QUERY),
  };

  /* ********************************************************** */
  // 'baseline' (INTEGER | 'newly' 'available' | 'widely' 'available' ('on' TIME)?) ('with' 'downstream')? ('including' 'kaios')?
  public static boolean baselineQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BASELINE_QUERY, "<baseline query>");
    r = consumeToken(b, "baseline");
    p = r; // pin = 1
    r = r && report_error_(b, baselineQuery_1(b, l + 1));
    r = p && report_error_(b, baselineQuery_2(b, l + 1)) && r;
    r = p && baselineQuery_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // INTEGER | 'newly' 'available' | 'widely' 'available' ('on' TIME)?
  private static boolean baselineQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    if (!r) r = baselineQuery_1_1(b, l + 1);
    if (!r) r = baselineQuery_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'newly' 'available'
  private static boolean baselineQuery_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "newly");
    r = r && consumeToken(b, "available");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'widely' 'available' ('on' TIME)?
  private static boolean baselineQuery_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "widely");
    r = r && consumeToken(b, "available");
    r = r && baselineQuery_1_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('on' TIME)?
  private static boolean baselineQuery_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_1_2_2")) return false;
    baselineQuery_1_2_2_0(b, l + 1);
    return true;
  }

  // 'on' TIME
  private static boolean baselineQuery_1_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_1_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "on");
    r = r && consumeToken(b, TIME);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('with' 'downstream')?
  private static boolean baselineQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_2")) return false;
    baselineQuery_2_0(b, l + 1);
    return true;
  }

  // 'with' 'downstream'
  private static boolean baselineQuery_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "with");
    r = r && consumeToken(b, "downstream");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('including' 'kaios')?
  private static boolean baselineQuery_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_3")) return false;
    baselineQuery_3_0(b, l + 1);
    return true;
  }

  // 'including' 'kaios'
  private static boolean baselineQuery_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baselineQuery_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "including");
    r = r && consumeToken(b, "kaios");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (EOL|COMMENT| fullSection | headlessSection)*
  static boolean browserslistFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "browserslistFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!browserslistFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "browserslistFile", c)) break;
    }
    return true;
  }

  // EOL|COMMENT| fullSection | headlessSection
  private static boolean browserslistFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "browserslistFile_0")) return false;
    boolean r;
    r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = fullSection(b, l + 1);
    if (!r) r = headlessSection(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'dead'
  public static boolean deadQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deadQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEAD_QUERY, "<dead query>");
    r = consumeToken(b, "dead");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'defaults'
  public static boolean defaultsQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defaultsQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFAULTS_QUERY, "<defaults query>");
    r = consumeToken(b, "defaults");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'extends' IDENTIFIER
  public static boolean extendsQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extendsQuery")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXTENDS_QUERY, "<extends query>");
    r = consumeToken(b, "extends");
    p = r; // pin = 1
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // sectionHeader COMMENT? (EOL sectionQueries)?
  public static boolean fullSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSection")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FULL_SECTION, null);
    r = sectionHeader(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, fullSection_1(b, l + 1));
    r = p && fullSection_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // COMMENT?
  private static boolean fullSection_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSection_1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  // (EOL sectionQueries)?
  private static boolean fullSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSection_2")) return false;
    fullSection_2_0(b, l + 1);
    return true;
  }

  // EOL sectionQueries
  private static boolean fullSection_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSection_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    r = r && sectionQueries(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sectionQueries
  public static boolean headlessSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "headlessSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADLESS_SECTION, "<headless section>");
    r = sectionQueries(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'last' INTEGER TARGET? 'major'? version
  public static boolean lastQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lastQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAST_QUERY, "<last query>");
    r = consumeToken(b, "last");
    r = r && consumeToken(b, INTEGER);
    r = r && lastQuery_2(b, l + 1);
    r = r && lastQuery_3(b, l + 1);
    r = r && version(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TARGET?
  private static boolean lastQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lastQuery_2")) return false;
    consumeToken(b, TARGET);
    return true;
  }

  // 'major'?
  private static boolean lastQuery_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lastQuery_3")) return false;
    consumeToken(b, "major");
    return true;
  }

  /* ********************************************************** */
  // !(EOL | COMMENT | '[' | <<eof>>) queryExpression (EOL queryExpression|COMMENT|EOL !'[')*
  static boolean queries_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries_")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = queries__0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, queryExpression(b, l + 1, -1));
    r = p && queries__2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !(EOL | COMMENT | '[' | <<eof>>)
  private static boolean queries__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !queries__0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EOL | COMMENT | '[' | <<eof>>
  private static boolean queries__0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EOL queryExpression|COMMENT|EOL !'[')*
  private static boolean queries__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!queries__2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "queries__2", c)) break;
    }
    return true;
  }

  // EOL queryExpression|COMMENT|EOL !'['
  private static boolean queries__2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = queries__2_0_0(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = queries__2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL queryExpression
  private static boolean queries__2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    r = r && queryExpression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL !'['
  private static boolean queries__2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    r = r && queries__2_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !'['
  private static boolean queries__2_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries__2_0_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, LBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // baselineQuery
  //     | statsQuery
  //     | lastQuery
  //     | timeQuery
  //     | unreleasedQuery
  //     | supportsQuery
  //     | targetQuery
  //     | extendsQuery
  //     | deadQuery
  //     | defaultsQuery
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, QUERY, "<query>");
    r = baselineQuery(b, l + 1);
    if (!r) r = statsQuery(b, l + 1);
    if (!r) r = lastQuery(b, l + 1);
    if (!r) r = timeQuery(b, l + 1);
    if (!r) r = unreleasedQuery(b, l + 1);
    if (!r) r = supportsQuery(b, l + 1);
    if (!r) r = targetQuery(b, l + 1);
    if (!r) r = extendsQuery(b, l + 1);
    if (!r) r = deadQuery(b, l + 1);
    if (!r) r = defaultsQuery(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(EOL|COMMENT|OR|AND|'[')
  static boolean query_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !query_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EOL|COMMENT|OR|AND|'['
  private static boolean query_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_recover_0")) return false;
    boolean r;
    r = consumeTokenFast(b, EOL);
    if (!r) r = consumeTokenFast(b, COMMENT);
    if (!r) r = consumeTokenFast(b, OR);
    if (!r) r = consumeTokenFast(b, AND);
    if (!r) r = consumeTokenFast(b, LBRACKET);
    return r;
  }

  /* ********************************************************** */
  // !(EOL | COMMENT | OR | AND | '[' | <<eof>>) query
  static boolean query_with_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_with_recover")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = query_with_recover_0(b, l + 1);
    p = r; // pin = 1
    r = r && query(b, l + 1);
    exit_section_(b, l, m, r, p, BrowserslistParser::query_recover);
    return r || p;
  }

  // !(EOL | COMMENT | OR | AND | '[' | <<eof>>)
  private static boolean query_with_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_with_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !query_with_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EOL | COMMENT | OR | AND | '[' | <<eof>>
  private static boolean query_with_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_with_recover_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' IDENTIFIER ']'
  public static boolean sectionHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sectionHeader")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SECTION_HEADER, "<section header>");
    r = consumeTokens(b, 1, LBRACKET, IDENTIFIER, RBRACKET);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, BrowserslistParser::sectionHeader_recover);
    return r || p;
  }

  /* ********************************************************** */
  // !(COMMENT | EOL)
  static boolean sectionHeader_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sectionHeader_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !sectionHeader_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT | EOL
  private static boolean sectionHeader_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sectionHeader_recover_0")) return false;
    boolean r;
    r = consumeTokenFast(b, COMMENT);
    if (!r) r = consumeTokenFast(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // (EOL|COMMENT)* queries_
  static boolean sectionQueries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sectionQueries")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sectionQueries_0(b, l + 1);
    r = r && queries_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EOL|COMMENT)*
  private static boolean sectionQueries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sectionQueries_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sectionQueries_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sectionQueries_0", c)) break;
    }
    return true;
  }

  // EOL|COMMENT
  private static boolean sectionQueries_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sectionQueries_0_0")) return false;
    boolean r;
    r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // (COMPARE|'cover') PERCENT ('in' IDENTIFIER 'stats'?)?
  public static boolean statsQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STATS_QUERY, "<stats query>");
    r = statsQuery_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, PERCENT));
    r = p && statsQuery_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // COMPARE|'cover'
  private static boolean statsQuery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery_0")) return false;
    boolean r;
    r = consumeToken(b, COMPARE);
    if (!r) r = consumeToken(b, "cover");
    return r;
  }

  // ('in' IDENTIFIER 'stats'?)?
  private static boolean statsQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery_2")) return false;
    statsQuery_2_0(b, l + 1);
    return true;
  }

  // 'in' IDENTIFIER 'stats'?
  private static boolean statsQuery_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "in");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && statsQuery_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'stats'?
  private static boolean statsQuery_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery_2_0_2")) return false;
    consumeToken(b, "stats");
    return true;
  }

  /* ********************************************************** */
  // ('partially' | 'fully')? 'supports' IDENTIFIER
  public static boolean supportsQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supportsQuery")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SUPPORTS_QUERY, "<supports query>");
    r = supportsQuery_0(b, l + 1);
    r = r && consumeToken(b, "supports");
    p = r; // pin = 2
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('partially' | 'fully')?
  private static boolean supportsQuery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supportsQuery_0")) return false;
    supportsQuery_0_0(b, l + 1);
    return true;
  }

  // 'partially' | 'fully'
  private static boolean supportsQuery_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supportsQuery_0_0")) return false;
    boolean r;
    r = consumeToken(b, "partially");
    if (!r) r = consumeToken(b, "fully");
    return r;
  }

  /* ********************************************************** */
  // TARGET (COMPARE? TARGET_VERSION | TARGET_VERSIONS_RANGE)
  //     | 'current' TARGET
  //     | 'maintained' TARGET version
  public static boolean targetQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TARGET_QUERY, "<target query>");
    r = targetQuery_0(b, l + 1);
    if (!r) r = targetQuery_1(b, l + 1);
    if (!r) r = targetQuery_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TARGET (COMPARE? TARGET_VERSION | TARGET_VERSIONS_RANGE)
  private static boolean targetQuery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TARGET);
    r = r && targetQuery_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMPARE? TARGET_VERSION | TARGET_VERSIONS_RANGE
  private static boolean targetQuery_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetQuery_0_1_0(b, l + 1);
    if (!r) r = consumeToken(b, TARGET_VERSIONS_RANGE);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMPARE? TARGET_VERSION
  private static boolean targetQuery_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetQuery_0_1_0_0(b, l + 1);
    r = r && consumeToken(b, TARGET_VERSION);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMPARE?
  private static boolean targetQuery_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery_0_1_0_0")) return false;
    consumeToken(b, COMPARE);
    return true;
  }

  // 'current' TARGET
  private static boolean targetQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "current");
    r = r && consumeToken(b, TARGET);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'maintained' TARGET version
  private static boolean targetQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetQuery_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "maintained");
    r = r && consumeToken(b, TARGET);
    r = r && version(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // timeQueryLast_ | timeQuerySince_
  public static boolean timeQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TIME_QUERY, "<time query>");
    r = timeQueryLast_(b, l + 1);
    if (!r) r = timeQuerySince_(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'last' (FLOAT|INTEGER) 'years'
  static boolean timeQueryLast_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeQueryLast_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "last");
    r = r && timeQueryLast__1(b, l + 1);
    r = r && consumeToken(b, "years");
    exit_section_(b, m, null, r);
    return r;
  }

  // FLOAT|INTEGER
  private static boolean timeQueryLast__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeQueryLast__1")) return false;
    boolean r;
    r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, INTEGER);
    return r;
  }

  /* ********************************************************** */
  // 'since' (TIME|INTEGER)
  static boolean timeQuerySince_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeQuerySince_")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, "since");
    p = r; // pin = 1
    r = r && timeQuerySince__1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TIME|INTEGER
  private static boolean timeQuerySince__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeQuerySince__1")) return false;
    boolean r;
    r = consumeToken(b, TIME);
    if (!r) r = consumeToken(b, INTEGER);
    return r;
  }

  /* ********************************************************** */
  // 'unreleased' TARGET? version
  public static boolean unreleasedQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unreleasedQuery")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNRELEASED_QUERY, "<unreleased query>");
    r = consumeToken(b, "unreleased");
    p = r; // pin = 1
    r = r && report_error_(b, unreleasedQuery_1(b, l + 1));
    r = p && version(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TARGET?
  private static boolean unreleasedQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unreleasedQuery_1")) return false;
    consumeToken(b, TARGET);
    return true;
  }

  /* ********************************************************** */
  // 'version' | 'versions'
  static boolean version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version")) return false;
    boolean r;
    r = consumeToken(b, "version");
    if (!r) r = consumeToken(b, "versions");
    return r;
  }

  /* ********************************************************** */
  // Expression root: queryExpression
  // Operator priority table:
  // 0: BINARY(orExpression)
  // 1: BINARY(andExpression)
  // 2: PREFIX(notExpression)
  // 3: ATOM(simpleExpression)
  public static boolean queryExpression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "queryExpression")) return false;
    addVariant(b, "<query expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<query expression>");
    r = notExpression(b, l + 1);
    if (!r) r = simpleExpression(b, l + 1);
    p = r;
    r = r && queryExpression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean queryExpression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "queryExpression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, OR)) {
        r = queryExpression(b, l, 0);
        exit_section_(b, l, m, OR_EXPRESSION, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, AND)) {
        r = queryExpression(b, l, 1);
        exit_section_(b, l, m, AND_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean notExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notExpression")) return false;
    if (!nextTokenIsSmart(b, NOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, NOT);
    p = r;
    r = p && queryExpression(b, l, 2);
    exit_section_(b, l, m, NOT_EXPRESSION, r, p, null);
    return r || p;
  }

  // query_with_recover
  public static boolean simpleExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_EXPRESSION, "<simple expression>");
    r = query_with_recover(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
