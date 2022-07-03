import com.github.aleksandrsl.intellijbrowserslist.BrowserslistParserDefinition
import com.intellij.testFramework.ParsingTestCase

class BrowserslistParsingTest: ParsingTestCase("", "browserslist", BrowserslistParserDefinition()) {
    fun testOverall() {
        doTest(true)
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
