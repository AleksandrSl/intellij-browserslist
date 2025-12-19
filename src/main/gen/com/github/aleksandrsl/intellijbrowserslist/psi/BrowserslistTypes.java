// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.aleksandrsl.intellijbrowserslist.psi.impl.*;

public interface BrowserslistTypes {

  IElementType AND_EXPRESSION = new BrowserslistElementType("AND_EXPRESSION");
  IElementType BASELINE_QUERY = new BrowserslistElementType("BASELINE_QUERY");
  IElementType DEAD_QUERY = new BrowserslistElementType("DEAD_QUERY");
  IElementType DEFAULTS_QUERY = new BrowserslistElementType("DEFAULTS_QUERY");
  IElementType EXTENDS_QUERY = new BrowserslistElementType("EXTENDS_QUERY");
  IElementType FULL_SECTION = new BrowserslistElementType("FULL_SECTION");
  IElementType HEADLESS_SECTION = new BrowserslistElementType("HEADLESS_SECTION");
  IElementType LAST_QUERY = new BrowserslistElementType("LAST_QUERY");
  IElementType NOT_EXPRESSION = new BrowserslistElementType("NOT_EXPRESSION");
  IElementType OR_EXPRESSION = new BrowserslistElementType("OR_EXPRESSION");
  IElementType QUERY = new BrowserslistElementType("QUERY");
  IElementType QUERY_EXPRESSION = new BrowserslistElementType("QUERY_EXPRESSION");
  IElementType SECTION_HEADER = new BrowserslistElementType("SECTION_HEADER");
  IElementType SIMPLE_EXPRESSION = new BrowserslistElementType("SIMPLE_EXPRESSION");
  IElementType STATS_QUERY = new BrowserslistElementType("STATS_QUERY");
  IElementType SUPPORTS_QUERY = new BrowserslistElementType("SUPPORTS_QUERY");
  IElementType TARGET_QUERY = new BrowserslistElementType("TARGET_QUERY");
  IElementType TIME_QUERY = new BrowserslistElementType("TIME_QUERY");
  IElementType UNRELEASED_QUERY = new BrowserslistElementType("UNRELEASED_QUERY");

  IElementType AND = new BrowserslistTokenType("and");
  IElementType COMMENT = new BrowserslistTokenType("COMMENT");
  IElementType COMPARE = new BrowserslistTokenType("COMPARE");
  IElementType EOL = new BrowserslistTokenType("EOL");
  IElementType FLOAT = new BrowserslistTokenType("FLOAT");
  IElementType IDENTIFIER = new BrowserslistTokenType("IDENTIFIER");
  IElementType INTEGER = new BrowserslistTokenType("INTEGER");
  IElementType LBRACKET = new BrowserslistTokenType("[");
  IElementType NOT = new BrowserslistTokenType("NOT");
  IElementType OR = new BrowserslistTokenType("or");
  IElementType PERCENT = new BrowserslistTokenType("PERCENT");
  IElementType RBRACKET = new BrowserslistTokenType("]");
  IElementType TARGET = new BrowserslistTokenType("TARGET");
  IElementType TARGET_VERSION = new BrowserslistTokenType("TARGET_VERSION");
  IElementType TARGET_VERSIONS_RANGE = new BrowserslistTokenType("TARGET_VERSIONS_RANGE");
  IElementType TIME = new BrowserslistTokenType("TIME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_EXPRESSION) {
        return new BrowserslistAndExpressionImpl(node);
      }
      else if (type == BASELINE_QUERY) {
        return new BrowserslistBaselineQueryImpl(node);
      }
      else if (type == DEAD_QUERY) {
        return new BrowserslistDeadQueryImpl(node);
      }
      else if (type == DEFAULTS_QUERY) {
        return new BrowserslistDefaultsQueryImpl(node);
      }
      else if (type == EXTENDS_QUERY) {
        return new BrowserslistExtendsQueryImpl(node);
      }
      else if (type == FULL_SECTION) {
        return new BrowserslistFullSectionImpl(node);
      }
      else if (type == HEADLESS_SECTION) {
        return new BrowserslistHeadlessSectionImpl(node);
      }
      else if (type == LAST_QUERY) {
        return new BrowserslistLastQueryImpl(node);
      }
      else if (type == NOT_EXPRESSION) {
        return new BrowserslistNotExpressionImpl(node);
      }
      else if (type == OR_EXPRESSION) {
        return new BrowserslistOrExpressionImpl(node);
      }
      else if (type == SECTION_HEADER) {
        return new BrowserslistSectionHeaderImpl(node);
      }
      else if (type == SIMPLE_EXPRESSION) {
        return new BrowserslistSimpleExpressionImpl(node);
      }
      else if (type == STATS_QUERY) {
        return new BrowserslistStatsQueryImpl(node);
      }
      else if (type == SUPPORTS_QUERY) {
        return new BrowserslistSupportsQueryImpl(node);
      }
      else if (type == TARGET_QUERY) {
        return new BrowserslistTargetQueryImpl(node);
      }
      else if (type == TIME_QUERY) {
        return new BrowserslistTimeQueryImpl(node);
      }
      else if (type == UNRELEASED_QUERY) {
        return new BrowserslistUnreleasedQueryImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
