// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.aleksandrsl.intellijbrowserslist.psi.*;

public class BrowserslistSectionImpl extends ASTWrapperPsiElement implements BrowserslistSection {

  public BrowserslistSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BrowserslistVisitor visitor) {
    visitor.visitSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BrowserslistVisitor) accept((BrowserslistVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BrowserslistSectionHeader getSectionHeader() {
    return findNotNullChildByClass(BrowserslistSectionHeader.class);
  }

  @Override
  @Nullable
  public BrowserslistSectionQueries getSectionQueries() {
    return findChildByClass(BrowserslistSectionQueries.class);
  }

  @Override
  @Nullable
  public PsiElement getEol() {
    return findChildByType(EOL);
  }

}
