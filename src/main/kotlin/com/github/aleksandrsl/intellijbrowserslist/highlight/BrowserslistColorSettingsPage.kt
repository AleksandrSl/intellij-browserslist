package com.github.aleksandrsl.intellijbrowserslist.highlight

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class BrowserslistColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return BrowserslistIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return BrowserslistSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """
extends browserslist-config-mycompany

[modern]
> 5% and > 10% in alt-AS

Android
Baidu
BlackBerry or bb 
        """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Browserslist"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Identifier", BrowserslistSyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Operator", BrowserslistSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Bad value", BrowserslistSyntaxHighlighter.BAD_CHARACTER)
        )
    }
}
