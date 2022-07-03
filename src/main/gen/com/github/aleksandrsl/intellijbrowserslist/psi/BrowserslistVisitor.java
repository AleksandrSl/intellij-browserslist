// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class BrowserslistVisitor extends PsiElementVisitor {

  public void visitDeadQuery(@NotNull BrowserslistDeadQuery o) {
    visitQuery(o);
  }

  public void visitDefaultsQuery(@NotNull BrowserslistDefaultsQuery o) {
    visitQuery(o);
  }

  public void visitExtendsQuery(@NotNull BrowserslistExtendsQuery o) {
    visitQuery(o);
  }

  public void visitLastQuery(@NotNull BrowserslistLastQuery o) {
    visitQuery(o);
  }

  public void visitQuery(@NotNull BrowserslistQuery o) {
    visitPsiElement(o);
  }

  public void visitQueryExpression(@NotNull BrowserslistQueryExpression o) {
    visitPsiElement(o);
  }

  public void visitSection(@NotNull BrowserslistSection o) {
    visitPsiElement(o);
  }

  public void visitSectionHeader(@NotNull BrowserslistSectionHeader o) {
    visitPsiElement(o);
  }

  public void visitSectionQueries(@NotNull BrowserslistSectionQueries o) {
    visitPsiElement(o);
  }

  public void visitStatsQuery(@NotNull BrowserslistStatsQuery o) {
    visitQuery(o);
  }

  public void visitSupportsQuery(@NotNull BrowserslistSupportsQuery o) {
    visitQuery(o);
  }

  public void visitTargetQuery(@NotNull BrowserslistTargetQuery o) {
    visitQuery(o);
  }

  public void visitTimeQuery(@NotNull BrowserslistTimeQuery o) {
    visitQuery(o);
  }

  public void visitUnreleasedQuery(@NotNull BrowserslistUnreleasedQuery o) {
    visitQuery(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
