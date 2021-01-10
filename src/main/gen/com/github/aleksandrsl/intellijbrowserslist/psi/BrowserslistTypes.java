// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.aleksandrsl.intellijbrowserslist.psi.impl.*;

public interface BrowserslistTypes {

  IElementType LAST_QUERY = new BrowserslistElementType("LAST_QUERY");
  IElementType STATS_QUERY = new BrowserslistElementType("STATS_QUERY");
  IElementType TIME_QUERY = new BrowserslistElementType("TIME_QUERY");
  IElementType UNRELEASED_QUERY = new BrowserslistElementType("UNRELEASED_QUERY");

  IElementType COMMENT = new BrowserslistTokenType("COMMENT");
  IElementType COMPARE = new BrowserslistTokenType("COMPARE");
  IElementType DEAD = new BrowserslistTokenType("DEAD");
  IElementType DEFAULTS = new BrowserslistTokenType("defaults");
  IElementType EOL = new BrowserslistTokenType("EOL");
  IElementType FLOAT = new BrowserslistTokenType("FLOAT");
  IElementType IN = new BrowserslistTokenType("in");
  IElementType INTEGER = new BrowserslistTokenType("INTEGER");
  IElementType LAST = new BrowserslistTokenType("last");
  IElementType LBRACKET = new BrowserslistTokenType("[");
  IElementType MAJOR = new BrowserslistTokenType("MAJOR");
  IElementType PERCENT = new BrowserslistTokenType("PERCENT");
  IElementType RBRACKET = new BrowserslistTokenType("]");
  IElementType SINCE = new BrowserslistTokenType("SINCE");
  IElementType STATS = new BrowserslistTokenType("STATS");
  IElementType TARGET = new BrowserslistTokenType("TARGET");
  IElementType TIME = new BrowserslistTokenType("TIME");
  IElementType UNRELEASED = new BrowserslistTokenType("UNRELEASED");
  IElementType VERSIONS = new BrowserslistTokenType("VERSIONS");
  IElementType YEARS = new BrowserslistTokenType("years");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == LAST_QUERY) {
        return new BrowserslistLastQueryImpl(node);
      }
      else if (type == STATS_QUERY) {
        return new BrowserslistStatsQueryImpl(node);
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
