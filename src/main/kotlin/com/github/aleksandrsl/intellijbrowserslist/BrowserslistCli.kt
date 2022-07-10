//package com.github.aleksandrsl.intellijbrowserslist
//
//import com.intellij.execution.configurations.GeneralCommandLine
//import com.intellij.execution.process.ProcessOutput
//import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
//import com.intellij.javascript.nodejs.util.NodePackage
//import com.intellij.openapi.progress.ProgressManager
//import com.intellij.openapi.project.Project
//
//class BrowserslistCli(private val browserslistPackage: NodePackage) {
//
//    private fun getCoverage_(project: Project): ProcessOutput {
//        val arguments = listOf()
//        NodeJsInterpreterManager.getInstance(project).interpreter
//
//        return GeneralCommandLine(elmFormatExecutablePath)
//            .withParameters(arguments)
//            .execute(elmFormatTool, project, stdIn = document.text)
//    }
//
//
//    fun getCoverage(project: Project) {
//        ProgressManager.getInstance().runProcessWithProgressSynchronously({
//            getFormattedContentOfDocument(version, document, project)
//        }, "Running elm-format on current file...", true, project)
//    }
//
////    fun formatDocumentAndSetText(project: Project, document: Document, version: Version, addToUndoStack: Boolean): ElmFormatResult {
////        val processOutput = try {
////            ProgressManager.getInstance().runProcessWithProgressSynchronously<ProcessOutput, ExecutionException>({
////                getFormattedContentOfDocument(version, document, project)
////            }, "Running elm-format on current file...", true, project)
////        } catch (e: ExecutionException) {
////            val msg = e.message ?: "unknown"
////            return when {
////                msg.contains("SYNTAX PROBLEM", ignoreCase = true) -> ElmFormatResult.BadSyntax()
////                e is ProcessNotCreatedException -> ElmFormatResult.FailedToStart()
////                else -> ElmFormatResult.UnknownFailure(cause = e)
////            }
////        }
////
////        if (processOutput.isNotSuccess) return ElmFormatResult.UnknownFailure("Process output exit code was non-zero", cause = null)
////
////        val formatted = processOutput.stdout
////        val source = document.text
////
////        if (source != formatted) {
////            val action = {
////                ApplicationManager.getApplication().runWriteAction {
////                    document.setText(formatted)
////                }
////            }
////
////            with(CommandProcessor.getInstance()) {
////                when {
////                    addToUndoStack -> executeCommand(project, action, "Run elm-format on current file", null, document)
////                    else -> runUndoTransparentAction(action)
////                }
////            }
////        }
////        return ElmFormatResult.Success()
////    }
//}