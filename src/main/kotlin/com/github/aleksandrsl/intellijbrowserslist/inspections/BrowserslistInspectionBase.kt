package com.github.aleksandrsl.intellijbrowserslist.inspections

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistBundle
import com.intellij.codeInspection.LocalInspectionTool

abstract class BrowserslistInspectionBase: LocalInspectionTool() {
    // Looks like this can be skipped, since we specify this in XML anyway.
    // Maybe it can be skipped from XML instead, but the inspection there is not that clever to detect this override.
    override fun getGroupDisplayName(): String {
        return BrowserslistBundle.message("browserslist.files.inspection.group.display.name")
    }
}
