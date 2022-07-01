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

public class BrowserslistEolSeparatedItemsImpl extends ASTWrapperPsiElement implements BrowserslistEolSeparatedItems {

  public BrowserslistEolSeparatedItemsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BrowserslistVisitor visitor) {
    visitor.visitEolSeparatedItems(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BrowserslistVisitor) accept((BrowserslistVisitor)visitor);
    else super.accept(visitor);
  }

}
