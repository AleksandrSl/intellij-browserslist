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
    b = adapt_builder_(t, b, this, null);
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

  /* ********************************************************** */
  // item_*
  static boolean browserslistFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "browserslistFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "browserslistFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // query_|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = query_(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // statsQuery
  static boolean query_(PsiBuilder b, int l) {
    return statsQuery(b, l + 1);
  }

  /* ********************************************************** */
  // COMPARE PERCENT (IN STATS)? CRLF
  public static boolean statsQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery")) return false;
    if (!nextTokenIs(b, COMPARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMPARE, PERCENT);
    r = r && statsQuery_2(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, m, STATS_QUERY, r);
    return r;
  }

  // (IN STATS)?
  private static boolean statsQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery_2")) return false;
    statsQuery_2_0(b, l + 1);
    return true;
  }

  // IN STATS
  private static boolean statsQuery_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statsQuery_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IN, STATS);
    exit_section_(b, m, null, r);
    return r;
  }

}
