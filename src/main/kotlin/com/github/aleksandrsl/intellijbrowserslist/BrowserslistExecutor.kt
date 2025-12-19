package com.github.aleksandrsl.intellijbrowserslist

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.CapturingProcessHandler
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.local.NodeJsLocalInterpreter
import com.intellij.javascript.nodejs.util.NodePackage
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File


/**
 * Data class representing browserslist JSON output.
 */
@Serializable
data class BrowserslistResult(
    val browsers: List<String>,
    val coverage: Coverage
)

@Serializable
data class Coverage(
    val global: Double
)

private val LOG = logger<BrowserslistExecutor>()

object BrowserslistExecutor {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    /**
     * Finds the browserslist package in the project
     * Returns null if browserslist is not installed.
     */
    fun findBrowserslistPackage(project: Project, contextFile: VirtualFile? = null): NodePackage? {
        val interpreter = NodeJsInterpreterManager.getInstance(project).interpreter
        if (interpreter !is NodeJsLocalInterpreter) {
            return null
        }

        val projectDir = project.basePath?.let { File(it) }
        if (projectDir != null) {
            val localPackage = NodePackage.findDefaultPackage(
                project,
                "browserslist",
                interpreter,
            )
            if (localPackage != null && localPackage.isValid(project, interpreter)) {
                return localPackage
            }
        }
        // Let's not search for browserslist globally, since we want real values you get during build
        return null
    }

    /**
     * Executes browserslist with the given query and returns the output.
     *
     * @param project The current project
     * @param queries The browserslist query (e.g., "last 2 versions")
     * @param configFile Optional path to .browserslistrc or package.json
     * @param timeout Timeout in milliseconds (default: 10 seconds)
     * @return ProcessOutput containing stdout, stderr, and exit code
     */
    fun executeBrowserslist(
        project: Project,
        queries: String,
        configFile: VirtualFile? = null,
        timeout: Int = 10_000
    ): BrowserslistResult? {
        val interpreter = NodeJsInterpreterManager.getInstance(project).interpreter
        if (interpreter !is NodeJsLocalInterpreter) {
            return null
        }

        val browserslistPackage = findBrowserslistPackage(project, configFile) ?: return null

        try {
            // Create command line
            val commandLine = GeneralCommandLine()
            commandLine.exePath = interpreter.interpreterSystemDependentPath

            val cliFile = browserslistPackage.findBinFile("browserslist", null)
            if (cliFile == null || !cliFile.exists()) {
                return null
            }
            commandLine.addParameter(cliFile.absolutePath)

            commandLine.addParameter("--json")
            commandLine.addParameter("--coverage")

            commandLine.addParameter(queries)

            // Set working directory to project directory or config file directory
            val workingDir = when {
                configFile != null -> configFile.parent.path
                project.basePath != null -> project.basePath
                else -> return null
            }
            commandLine.setWorkDirectory(workingDir)

            val processHandler = CapturingProcessHandler(commandLine)
            val output = processHandler.runProcess(timeout)
            if (output.exitCode == 0) {
                val jsonOutput = output.stdout
                if (jsonOutput.isNotBlank()) {
                    return try {
                        json.decodeFromString<BrowserslistResult>(jsonOutput)
                    } catch (e: Exception) {
                        LOG.warn("Failed to parse browserslist output: $jsonOutput")
                        null
                    }
                }
                LOG.warn("Browserslist output is empty")
            } else {
                LOG.warn("Browserslist execution failed with exit code ${output.exitCode}: ${output.stderr}")
            }
            return null
        } catch (e: ExecutionException) {
            LOG.warn("Browserslist execution failed with an error", e)
            return null
        }
    }
}
