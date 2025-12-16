import com.github.aleksandrsl.intellijbrowserslist.BrowserslistParserDefinition
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFile
import com.intellij.testFramework.ParsingTestCase

class BrowserslistParsingTest: ParsingTestCase("", "browserslist", BrowserslistParserDefinition()) {
    fun testOverall() {
        doTest(true)
    }

    private fun hasErrors(file: PsiFile): Boolean {
        var hasErrors = false
        file.accept(object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is PsiErrorElement) {
                    hasErrors = true
                    return
                }
                element.acceptChildren(this)
            }
        })
        return hasErrors
    }

    override fun checkResult(targetDataName: String, file: PsiFile) {
        // I took a peek at how they do the tests in rust https://github.com/search?q=repo%3Aintellij-rust/intellij-rust%20hasError&type=code,
        // and the super call is positioned differently in checkResult for valid and invalid files.
        // I guess for valid files all other errors should go first so the super call is first,
        // or it is a bug and I just copied it, lol.
        super.checkResult(targetDataName, file)
        check(!hasErrors(file)) {
            "Valid file was parsed with errors: ${file.name}"
        }
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}
