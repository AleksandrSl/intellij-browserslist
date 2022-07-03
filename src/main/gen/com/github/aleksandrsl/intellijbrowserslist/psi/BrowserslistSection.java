// This is a generated file. Not intended for manual editing.
package com.github.aleksandrsl.intellijbrowserslist.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BrowserslistSection extends PsiElement {

  @NotNull
  BrowserslistSectionHeader getSectionHeader();

  @Nullable
  BrowserslistSectionQueries getSectionQueries();

  @Nullable
  PsiElement getEol();

}
