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
    builder_ = adapt_builder_(root_, builder_, this, null);
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

  /* ********************************************************** */
  // item_*
  static boolean browserslistFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "browserslistFile")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!item_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "browserslistFile", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // DEFAULTS|query_|COMMENT|EOL
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    boolean result_;
    result_ = consumeToken(builder_, DEFAULTS);
    if (!result_) result_ = query_(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // LAST INTEGER MAJOR? VERSIONS
  public static boolean lastQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lastQuery")) return false;
    if (!nextTokenIs(builder_, LAST)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, LAST, INTEGER);
    result_ = result_ && lastQuery_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VERSIONS);
    exit_section_(builder_, marker_, LAST_QUERY, result_);
    return result_;
  }

  // MAJOR?
  private static boolean lastQuery_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lastQuery_2")) return false;
    consumeToken(builder_, MAJOR);
    return true;
  }

  /* ********************************************************** */
  // (statsQuery | lastQuery) EOL
  static boolean query_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query_")) return false;
    if (!nextTokenIs(builder_, "", COMPARE, LAST)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = query__0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // statsQuery | lastQuery
  private static boolean query__0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "query__0")) return false;
    boolean result_;
    result_ = statsQuery(builder_, level_ + 1);
    if (!result_) result_ = lastQuery(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // COMPARE PERCENT (IN STATS)?
  public static boolean statsQuery(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statsQuery")) return false;
    if (!nextTokenIs(builder_, COMPARE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COMPARE, PERCENT);
    result_ = result_ && statsQuery_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, STATS_QUERY, result_);
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

}
