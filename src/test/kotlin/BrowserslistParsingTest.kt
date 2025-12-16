import com.intellij.psi.PsiFile

class BrowserslistParsingTest : BrowserslistParsingBaseTestCase() {
    fun testOverall() {
        doTest(true)
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
}
