package inspections

data class QuickFix(val name: String, val key: String)

abstract class BaseInspectionQuickFixTestCase(
    inspection: Inspection, private val quickFix: QuickFix
) : BaseInspectionTestCase(inspection) {

    override fun getTestDataPath(): String {
        return "${super.getTestDataPath()}/${quickFix.key}"
    }

    protected fun doTest() {
        val testName = getTestName(false)
        myFixture.configureByFile("$testName.browserslistrc")
        val highlightInfos = myFixture.doHighlighting()
        assertFalse(highlightInfos.isEmpty())
        val action = myFixture.findSingleIntention(quickFix.name)
        assertNotNull(action)
        myFixture.launchAction(action)
        myFixture.checkResultByFile("$testName.after.browserslistrc")
    }
}
