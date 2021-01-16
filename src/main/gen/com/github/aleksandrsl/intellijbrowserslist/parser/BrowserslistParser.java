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

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, EXTENDS_SETS_);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return browserslistFile(builder_, level_ + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(DEAD_QUERY, DEFAULTS_QUERY, EXTENDS_QUERY, LAST_QUERY,
      QUERY, STATS_QUERY, SUPPORTS_QUERY, TARGET_QUERY,
      TIME_QUERY, UNRELEASED_QUERY),
  };

  /* ********************************************************** */
  // (EOL|COMMENT)* (queries_ (EOL sections_)?|sections_)
  static boolean browserslistFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = browserslistFile_0(builder_, level_ + 1);
    result_ = result_ && browserslistFile_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (EOL|COMMENT)*
  private static boolean browserslistFile_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!browserslistFile_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "browserslistFile_0", pos_)) break;
    }
    return true;
  }

  // EOL|COMMENT
  private static boolean browserslistFile_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    return result_;
  }

  // queries_ (EOL sections_)?|sections_
  private static boolean browserslistFile_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = browserslistFile_1_0(builder_, level_ + 1);
    if (!result_) result_ = sections_(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // queries_ (EOL sections_)?
  private static boolean browserslistFile_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = queries_(builder_, level_ + 1);
    result_ = result_ && browserslistFile_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (EOL sections_)?
  private static boolean browserslistFile_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile_1_0_1")) return false;
    browserslistFile_1_0_1_0(builder_, level_ + 1);
    return true;
  }

  // EOL sections_
  private static boolean browserslistFile_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile_1_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EOL);
    result_ = result_ && sections_(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // DEAD
  public static boolean deadQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "deadQuery")) return false;
    if (!nextTokenIs(builder_, DEAD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DEAD);
    exit_section_(builder_, marker_, DEAD_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // DEFAULTS
  public static boolean defaultsQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "defaultsQuery")) return false;
    if (!nextTokenIs(builder_, DEFAULTS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DEFAULTS);
    exit_section_(builder_, marker_, DEFAULTS_QUERY, result_);
    return result_;
  }

  /* ********************************************************** */
  // (EOL|COMMENT)* <<item>> (EOL <<item>>|COMMENT|EOL !'[')*
  public static boolean eolSeparatedItems(PsiBuilder builder_, int level_, Parser item) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EOL_SEPARATED_ITEMS, null);
    result_ = eolSeparatedItems_0(builder_, level_ + 1);
    result_ = result_ && item.parse(builder_, level_);
    result_ = result_ && eolSeparatedItems_2(builder_, level_ + 1, item);
    exit_section_(builder_, level_, marker_, result_, false, BrowserslistParser::eolSeparatedItems_recover);
    return result_;
  }

  // (EOL|COMMENT)*
  private static boolean eolSeparatedItems_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!eolSeparatedItems_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "eolSeparatedItems_0", pos_)) break;
    }
    return true;
  }

  // EOL|COMMENT
  private static boolean eolSeparatedItems_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    return result_;
  }

  // (EOL <<item>>|COMMENT|EOL !'[')*
  private static boolean eolSeparatedItems_2(PsiBuilder builder_, int level_, Parser item) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!eolSeparatedItems_2_0(builder_, level_ + 1, item)) break;
      if (!empty_element_parsed_guard_(builder_, "eolSeparatedItems_2", pos_)) break;
    }
    return true;
  }

  // EOL <<item>>|COMMENT|EOL !'['
  private static boolean eolSeparatedItems_2_0(PsiBuilder builder_, int level_, Parser item) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = eolSeparatedItems_2_0_0(builder_, level_ + 1, item);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = eolSeparatedItems_2_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EOL <<item>>
  private static boolean eolSeparatedItems_2_0_0(PsiBuilder builder_, int level_, Parser item) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EOL);
    result_ = result_ && item.parse(builder_, level_);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EOL !'['
  private static boolean eolSeparatedItems_2_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_2_0_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EOL);
    result_ = result_ && eolSeparatedItems_2_0_2_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !'['
  private static boolean eolSeparatedItems_2_0_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_2_0_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, LBRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // !(EOL '[')
  static boolean eolSeparatedItems_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_recover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !eolSeparatedItems_recover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // EOL '['
  private static boolean eolSeparatedItems_recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eolSeparatedItems_recover_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, EOL, LBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // EXTENDS IDENTIFIER
  public static boolean extendsQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "extendsQuery")) return false;
    if (!nextTokenIs(builder_, EXTENDS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXTENDS_QUERY, null);
    result_ = consumeTokens(builder_, 1, EXTENDS, IDENTIFIER);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // LAST INTEGER TARGET? MAJOR? VERSIONS
  public static boolean lastQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lastQuery")) return false;
    if (!nextTokenIs(builder_, LAST)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, LAST, INTEGER);
    result_ = result_ && lastQuery_2(builder_, level_ + 1);
    result_ = result_ && lastQuery_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VERSIONS);
    exit_section_(builder_, marker_, LAST_QUERY, result_);
    return result_;
  }

  // TARGET?
  private static boolean lastQuery_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lastQuery_2")) return false;
    consumeToken(builder_, TARGET);
    return true;
  }

  // MAJOR?
  private static boolean lastQuery_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lastQuery_3")) return false;
    consumeToken(builder_, MAJOR);
    return true;
  }

  /* ********************************************************** */
  // <<eolSeparatedItems queryExpression_>>
  static boolean queries_(PsiBuilder builder_, int level_) {
    return eolSeparatedItems(builder_, level_ + 1, BrowserslistParser::queryExpression_);
  }

  /* ********************************************************** */
  // statsQuery
  //     | lastQuery
  //     | timeQuery
  //     | unreleasedQuery
  //     | supportsQuery
  //     | targetQuery
  //     | extendsQuery
  //     | deadQuery
  //     | defaultsQuery
  public static boolean query(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, QUERY, "<query>");
    result_ = statsQuery(builder_, level_ + 1);
    if (!result_) result_ = lastQuery(builder_, level_ + 1);
    if (!result_) result_ = timeQuery(builder_, level_ + 1);
    if (!result_) result_ = unreleasedQuery(builder_, level_ + 1);
    if (!result_) result_ = supportsQuery(builder_, level_ + 1);
    if (!result_) result_ = targetQuery(builder_, level_ + 1);
    if (!result_) result_ = extendsQuery(builder_, level_ + 1);
    if (!result_) result_ = deadQuery(builder_, level_ + 1);
    if (!result_) result_ = defaultsQuery(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, BrowserslistParser::query_recover);
    return result_;
  }

  /* ********************************************************** */
  // NOT? query ((AND|OR) NOT? query)*
  static boolean queryExpression_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression_")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = queryExpression__0(builder_, level_ + 1);
    result_ = result_ && query(builder_, level_ + 1);
    result_ = result_ && queryExpression__2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, BrowserslistParser::queryExpression_recover);
    return result_;
  }

  // NOT?
  private static boolean queryExpression__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression__0")) return false;
    consumeToken(builder_, NOT);
    return true;
  }

  // ((AND|OR) NOT? query)*
  private static boolean queryExpression__2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression__2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!queryExpression__2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "queryExpression__2", pos_)) break;
    }
    return true;
  }

  // (AND|OR) NOT? query
  private static boolean queryExpression__2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression__2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = queryExpression__2_0_0(builder_, level_ + 1);
    result_ = result_ && queryExpression__2_0_1(builder_, level_ + 1);
    result_ = result_ && query(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // AND|OR
  private static boolean queryExpression__2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression__2_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, OR);
    return result_;
  }

  // NOT?
  private static boolean queryExpression__2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression__2_0_1")) return false;
    consumeToken(builder_, NOT);
    return true;
  }

  /* ********************************************************** */
  // !(EOL|COMMENT)
  static boolean queryExpression_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression_recover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !queryExpression_recover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // EOL|COMMENT
  private static boolean queryExpression_recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "queryExpression_recover_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    return result_;
  }

  /* ********************************************************** */
  // !(EOL|COMMENT|OR|AND)
  static boolean query_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query_recover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !query_recover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // EOL|COMMENT|OR|AND
  private static boolean query_recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query_recover_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, OR);
    if (!result_) result_ = consumeToken(builder_, AND);
    return result_;
  }

  /* ********************************************************** */
  // sectionHeader COMMENT? (EOL queries_)?
  public static boolean section(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "section")) return false;
    if (!nextTokenIs(builder_, LBRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SECTION, null);
    result_ = sectionHeader(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, section_1(builder_, level_ + 1));
    result_ = pinned_ && section_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // COMMENT?
  private static boolean section_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "section_1")) return false;
    consumeToken(builder_, COMMENT);
    return true;
  }

  // (EOL queries_)?
  private static boolean section_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "section_2")) return false;
    section_2_0(builder_, level_ + 1);
    return true;
  }

  // EOL queries_
  private static boolean section_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "section_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EOL);
    result_ = result_ && queries_(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '[' IDENTIFIER+ ']'
  public static boolean sectionHeader(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sectionHeader")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SECTION_HEADER, "<section header>");
    result_ = consumeToken(builder_, LBRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, sectionHeader_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, BrowserslistParser::sectionHeader_recover);
    return result_ || pinned_;
  }

  // IDENTIFIER+
  private static boolean sectionHeader_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sectionHeader_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, IDENTIFIER)) break;
      if (!empty_element_parsed_guard_(builder_, "sectionHeader_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // !(COMMENT | EOL)
  static boolean sectionHeader_recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sectionHeader_recover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !sectionHeader_recover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // COMMENT | EOL
  private static boolean sectionHeader_recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sectionHeader_recover_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // <<eolSeparatedItems section>>
  static boolean sections_(PsiBuilder builder_, int level_) {
    return eolSeparatedItems(builder_, level_ + 1, BrowserslistParser::section);
  }

  /* ********************************************************** */
  // (COMPARE|COVER) PERCENT (IN STATS)?
  public static boolean statsQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statsQuery")) return false;
    if (!nextTokenIs(builder_, "<stats query>", COMPARE, COVER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STATS_QUERY, "<stats query>");
    result_ = statsQuery_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, PERCENT));
    result_ = pinned_ && statsQuery_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // COMPARE|COVER
  private static boolean statsQuery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statsQuery_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, COMPARE);
    if (!result_) result_ = consumeToken(builder_, COVER);
    return result_;
  }

  // (IN STATS)?
  private static boolean statsQuery_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statsQuery_2")) return false;
    statsQuery_2_0(builder_, level_ + 1);
    return true;
  }

  // IN STATS
  private static boolean statsQuery_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statsQuery_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IN, STATS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SUPPORTS FEATURE
  public static boolean supportsQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "supportsQuery")) return false;
    if (!nextTokenIs(builder_, SUPPORTS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SUPPORTS_QUERY, null);
    result_ = consumeTokens(builder_, 1, SUPPORTS, FEATURE);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // TARGET (COMPARE? TARGET_VERSION | TARGET_VERSIONS_RANGE)
  //     | CURRENT_NODE_VERSION TARGET
  //     | MAINTAINED_NODE_VERSIONS TARGET VERSIONS
  public static boolean targetQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "targetQuery")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TARGET_QUERY, "<target query>");
    result_ = targetQuery_0(builder_, level_ + 1);
    if (!result_) result_ = parseTokens(builder_, 0, CURRENT_NODE_VERSION, TARGET);
    if (!result_) result_ = parseTokens(builder_, 0, MAINTAINED_NODE_VERSIONS, TARGET, VERSIONS);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // TARGET (COMPARE? TARGET_VERSION | TARGET_VERSIONS_RANGE)
  private static boolean targetQuery_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "targetQuery_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TARGET);
    result_ = result_ && targetQuery_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMPARE? TARGET_VERSION | TARGET_VERSIONS_RANGE
  private static boolean targetQuery_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "targetQuery_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = targetQuery_0_1_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TARGET_VERSIONS_RANGE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMPARE? TARGET_VERSION
  private static boolean targetQuery_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "targetQuery_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = targetQuery_0_1_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, TARGET_VERSION);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COMPARE?
  private static boolean targetQuery_0_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "targetQuery_0_1_0_0")) return false;
    consumeToken(builder_, COMPARE);
    return true;
  }

  /* ********************************************************** */
  // timeQueryLast_ | timeQuerySince_
  public static boolean timeQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "timeQuery")) return false;
    if (!nextTokenIs(builder_, "<time query>", LAST, SINCE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TIME_QUERY, "<time query>");
    result_ = timeQueryLast_(builder_, level_ + 1);
    if (!result_) result_ = timeQuerySince_(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LAST (FLOAT|INTEGER) YEARS
  static boolean timeQueryLast_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "timeQueryLast_")) return false;
    if (!nextTokenIs(builder_, LAST)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LAST);
    result_ = result_ && timeQueryLast__1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, YEARS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // FLOAT|INTEGER
  private static boolean timeQueryLast__1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "timeQueryLast__1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, INTEGER);
    return result_;
  }

  /* ********************************************************** */
  // SINCE (TIME|INTEGER)
  static boolean timeQuerySince_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "timeQuerySince_")) return false;
    if (!nextTokenIs(builder_, SINCE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, SINCE);
    pinned_ = result_; // pin = 1
    result_ = result_ && timeQuerySince__1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // TIME|INTEGER
  private static boolean timeQuerySince__1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "timeQuerySince__1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, TIME);
    if (!result_) result_ = consumeToken(builder_, INTEGER);
    return result_;
  }

  /* ********************************************************** */
  // UNRELEASED TARGET? VERSIONS
  public static boolean unreleasedQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unreleasedQuery")) return false;
    if (!nextTokenIs(builder_, UNRELEASED)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, UNRELEASED_QUERY, null);
    result_ = consumeToken(builder_, UNRELEASED);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, unreleasedQuery_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, VERSIONS) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // TARGET?
  private static boolean unreleasedQuery_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unreleasedQuery_1")) return false;
    consumeToken(builder_, TARGET);
    return true;
  }

}
