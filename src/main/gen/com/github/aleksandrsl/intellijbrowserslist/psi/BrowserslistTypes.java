// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.aleksandrsl.intellijbrowserslist.psi.impl.*;

public interface BrowserslistTypes {

  IElementType DEAD_QUERY = new BrowserslistElementType("DEAD_QUERY");
  IElementType DEFAULTS_QUERY = new BrowserslistElementType("DEFAULTS_QUERY");
  IElementType EXTENDS_QUERY = new BrowserslistElementType("EXTENDS_QUERY");
  IElementType LAST_QUERY = new BrowserslistElementType("LAST_QUERY");
  IElementType QUERY = new BrowserslistElementType("QUERY");
  IElementType QUERY_EXPRESSION = new BrowserslistElementType("QUERY_EXPRESSION");
  IElementType SECTION = new BrowserslistElementType("SECTION");
  IElementType SECTION_HEADER = new BrowserslistElementType("SECTION_HEADER");
  IElementType SECTION_QUERIES = new BrowserslistElementType("SECTION_QUERIES");
  IElementType STATS_QUERY = new BrowserslistElementType("STATS_QUERY");
  IElementType SUPPORTS_QUERY = new BrowserslistElementType("SUPPORTS_QUERY");
  IElementType TARGET_QUERY = new BrowserslistElementType("TARGET_QUERY");
  IElementType TIME_QUERY = new BrowserslistElementType("TIME_QUERY");
  IElementType UNRELEASED_QUERY = new BrowserslistElementType("UNRELEASED_QUERY");

  IElementType AND = new BrowserslistTokenType("AND");
  IElementType COMMENT = new BrowserslistTokenType("COMMENT");
  IElementType COMPARE = new BrowserslistTokenType("COMPARE");
  IElementType COVER = new BrowserslistTokenType("COVER");
  IElementType CURRENT_NODE_VERSION = new BrowserslistTokenType("CURRENT_NODE_VERSION");
  IElementType DEAD = new BrowserslistTokenType("DEAD");
  IElementType DEFAULTS = new BrowserslistTokenType("defaults");
  IElementType EOL = new BrowserslistTokenType("EOL");
  IElementType EXTENDS = new BrowserslistTokenType("EXTENDS");
  IElementType FEATURE = new BrowserslistTokenType("FEATURE");
  IElementType FLOAT = new BrowserslistTokenType("FLOAT");
  IElementType IDENTIFIER = new BrowserslistTokenType("IDENTIFIER");
  IElementType IN = new BrowserslistTokenType("in");
  IElementType INTEGER = new BrowserslistTokenType("INTEGER");
  IElementType LAST = new BrowserslistTokenType("last");
  IElementType LBRACKET = new BrowserslistTokenType("[");
  IElementType MAINTAINED_NODE_VERSIONS = new BrowserslistTokenType("MAINTAINED_NODE_VERSIONS");
  IElementType MAJOR = new BrowserslistTokenType("MAJOR");
  IElementType NOT = new BrowserslistTokenType("NOT");
  IElementType OR = new BrowserslistTokenType("OR");
  IElementType PERCENT = new BrowserslistTokenType("PERCENT");
  IElementType RBRACKET = new BrowserslistTokenType("]");
  IElementType SINCE = new BrowserslistTokenType("SINCE");
  IElementType STATS = new BrowserslistTokenType("STATS");
  IElementType SUPPORTS = new BrowserslistTokenType("SUPPORTS");
  IElementType TARGET = new BrowserslistTokenType("TARGET");
  IElementType TARGET_VERSION = new BrowserslistTokenType("TARGET_VERSION");
  IElementType TARGET_VERSIONS_RANGE = new BrowserslistTokenType("TARGET_VERSIONS_RANGE");
  IElementType TIME = new BrowserslistTokenType("TIME");
  IElementType UNRELEASED = new BrowserslistTokenType("UNRELEASED");
  IElementType VERSIONS = new BrowserslistTokenType("VERSIONS");
  IElementType YEARS = new BrowserslistTokenType("years");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DEAD_QUERY) {
        return new BrowserslistDeadQueryImpl(node);
      }
      else if (type == DEFAULTS_QUERY) {
        return new BrowserslistDefaultsQueryImpl(node);
      }
      else if (type == EXTENDS_QUERY) {
        return new BrowserslistExtendsQueryImpl(node);
      }
      else if (type == LAST_QUERY) {
        return new BrowserslistLastQueryImpl(node);
      }
      else if (type == QUERY) {
        return new BrowserslistQueryImpl(node);
      }
      else if (type == QUERY_EXPRESSION) {
        return new BrowserslistQueryExpressionImpl(node);
      }
      else if (type == SECTION) {
        return new BrowserslistSectionImpl(node);
      }
      else if (type == SECTION_HEADER) {
        return new BrowserslistSectionHeaderImpl(node);
      }
      else if (type == SECTION_QUERIES) {
        return new BrowserslistSectionQueriesImpl(node);
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
