package inspections


abstract class BaseInspectionNoErrorsTestCase(
    inspection: Inspection,
) : BaseInspectionTestCase(inspection) {

    override fun getTestDataPath(): String {
        return "${super.testDataPath}/NoErrors"
    }

    protected fun doTest() {
        val testName = getTestName(false)
        myFixture.configureByFile("$testName.browserslistrc")
        val highlightInfos = myFixture.doHighlighting()
        assertTrue(highlightInfos.isEmpty())
    }
}
