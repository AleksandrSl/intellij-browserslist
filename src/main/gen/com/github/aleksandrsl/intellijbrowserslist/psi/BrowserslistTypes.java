// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.aleksandrsl.intellijbrowserslist.psi.impl.*;

public interface BrowserslistTypes {

  IElementType STATS_QUERY = new BrowserslistElementType("STATS_QUERY");

  IElementType COMMENT = new BrowserslistTokenType("COMMENT");
  IElementType COMPARE = new BrowserslistTokenType("COMPARE");
  IElementType CRLF = new BrowserslistTokenType("CRLF");
  IElementType IN = new BrowserslistTokenType("IN");
  IElementType PERCENT = new BrowserslistTokenType("PERCENT");
  IElementType STATS = new BrowserslistTokenType("STATS");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == STATS_QUERY) {
        return new BrowserslistStatsQueryImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
