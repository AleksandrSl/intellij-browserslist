// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes.*;
import com.github.aleksandrsl.intellijbrowserslist.psi.*;

public class BrowserslistBinaryExpressionImpl extends BrowserslistQueryExpressionImpl implements BrowserslistBinaryExpression {

  public BrowserslistBinaryExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BrowserslistVisitor visitor) {
    visitor.visitBinaryExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BrowserslistVisitor) accept((BrowserslistVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BrowserslistQueryExpression> getQueryExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BrowserslistQueryExpression.class);
  }

  @Override
  @NotNull
  public BrowserslistQueryExpression getLeft() {
    List<BrowserslistQueryExpression> p1 = getQueryExpressionList();
    return p1.get(0);
  }

  @Override
  @Nullable
  public BrowserslistQueryExpression getRight() {
    List<BrowserslistQueryExpression> p1 = getQueryExpressionList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
