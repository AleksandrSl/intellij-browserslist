package parser

import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistQueryExpression
import com.github.aleksandrsl.intellijbrowserslist.psi.BrowserslistSimpleExpression
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.parents
import java.io.IOException

class BrowsersListParsingErrorRecoveryTest : BrowserslistParsingBaseTestCase("recovery") {

    fun testQuery() = doTest(BrowserslistSimpleExpression::class.java)
    fun testQueryExpression() = doTest(BrowserslistQueryExpression::class.java)

    private fun doTest(target: Class<out PsiElement>) {
        val name = testName
        try {
            parseFile(name, loadFile("$name.$myFileExt"))
            checkResult(name, myFile, target)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    private fun checkResult(targetDataName: String, file: PsiFile, target: Class<out PsiElement>) {
        when (val result = hasErrorsInSpecificElementType(file, target)) {
            ErrorRecoveryResult.Success -> {}
            ErrorRecoveryResult.ErrorNotFound -> fail("No error found in file $targetDataName")
            is ErrorRecoveryResult.UnexpectedError -> fail("Unexpected error found in file $targetDataName: ${result.trace}")
        }
        super.checkResult(targetDataName, file)
    }

    private fun hasErrorsInSpecificElementType(file: PsiFile, targetType: Class<out PsiElement>): ErrorRecoveryResult {
        var requiredErrorFound = false
        var unexpectedErrorTrace: String? = null
        file.accept(object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {

                if (element is PsiErrorElement) {
                    unexpectedErrorTrace = element.parents(true).map { it.node.toString() }.joinToString(",")
                    return
                }

                if (targetType.isInstance(element)) {
                    element.acceptChildren(object : PsiElementVisitor() {
                        override fun visitElement(child: PsiElement) {
                            if (child is PsiErrorElement) {
                                requiredErrorFound = true
                            } else {
                                child.acceptChildren(this)
                            }
                        }
                    })
                } else {
                    element.acceptChildren(this)
                }
            }
        })
        if (!requiredErrorFound) {
            return ErrorRecoveryResult.ErrorNotFound
        }

        if (unexpectedErrorTrace != null) {
            return ErrorRecoveryResult.UnexpectedError(unexpectedErrorTrace)
        }
        return ErrorRecoveryResult.Success
    }
}

sealed class ErrorRecoveryResult {
    data object Success : ErrorRecoveryResult()
    data object ErrorNotFound : ErrorRecoveryResult()
    data class UnexpectedError(val trace: String) : ErrorRecoveryResult()
}
