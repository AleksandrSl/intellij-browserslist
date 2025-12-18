// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class BrowserslistVisitor extends PsiElementVisitor {

  public void visitAndExpression(@NotNull BrowserslistAndExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBaselineQuery(@NotNull BrowserslistBaselineQuery o) {
    visitQuery(o);
  }

  public void visitBinaryExpression(@NotNull BrowserslistBinaryExpression o) {
    visitQueryExpression(o);
  }

  public void visitDeadQuery(@NotNull BrowserslistDeadQuery o) {
    visitQuery(o);
  }

  public void visitDefaultsQuery(@NotNull BrowserslistDefaultsQuery o) {
    visitQuery(o);
  }

  public void visitExtendsQuery(@NotNull BrowserslistExtendsQuery o) {
    visitQuery(o);
  }

  public void visitFullSection(@NotNull BrowserslistFullSection o) {
    visitSection(o);
  }

  public void visitHeadlessSection(@NotNull BrowserslistHeadlessSection o) {
    visitSection(o);
  }

  public void visitLastQuery(@NotNull BrowserslistLastQuery o) {
    visitQuery(o);
  }

  public void visitNotExpression(@NotNull BrowserslistNotExpression o) {
    visitQueryExpression(o);
  }

  public void visitOrExpression(@NotNull BrowserslistOrExpression o) {
    visitBinaryExpression(o);
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

  public void visitSimpleExpression(@NotNull BrowserslistSimpleExpression o) {
    visitQueryExpression(o);
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
