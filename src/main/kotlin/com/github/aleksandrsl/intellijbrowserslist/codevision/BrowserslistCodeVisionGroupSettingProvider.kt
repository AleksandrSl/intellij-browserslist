package com.github.aleksandrsl.intellijbrowserslist.codevision

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistBundle
import com.intellij.codeInsight.codeVision.settings.CodeVisionGroupSettingProvider

class BrowserslistCodeVisionGroupSettingProvider  : CodeVisionGroupSettingProvider {
    override val groupId = CODE_VISION_GROUP_ID
    override val description: String get() = BrowserslistBundle.message("browserslist.codevision.stats.description")
    override val groupName: String get() = "Browserslist"
}

const val CODE_VISION_GROUP_ID = "browserslist"
