// Copyright 2000-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.javascript.nodejs.util.NodePackage
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

interface BrowserslistLanguageService {
    fun coverage(
        filePath: String,
        queries: Array<String>
    ): Future<CoverageResult>?

    class CoverageResult private constructor(val result: Float?, val error: String?) {

        companion object {
            fun error(error: String): CoverageResult = CoverageResult(null, error)

            fun result(result: Float?): CoverageResult = CoverageResult(result, null)
        }
    }

    companion object {
        private val LOG: Logger = Logger.getInstance(BrowserslistLanguageService::class.java)
        fun getInstance(project: Project): BrowserslistLanguageService {
            LOG.warn(project.toString())
            // Fucked up here, for some reason I had BrowserslistLanguageServiceImpl here.
            return project.getService(BrowserslistLanguageService::class.java)
        }
    }
}