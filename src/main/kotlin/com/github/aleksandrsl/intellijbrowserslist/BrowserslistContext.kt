package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class BrowserslistContext : TemplateContextType("browserslist", "Browserslist") {

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.fileType is BrowserslistFileType
    }
}
