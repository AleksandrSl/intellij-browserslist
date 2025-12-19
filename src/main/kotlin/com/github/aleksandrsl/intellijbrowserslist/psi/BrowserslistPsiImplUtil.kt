package com.github.aleksandrsl.intellijbrowserslist.psi

// Unfortunately generator can't use value classes yet
fun getSectionName(element: BrowserslistSection): String = element.sectionHeader?.nameElement?.text ?: "defaults"
