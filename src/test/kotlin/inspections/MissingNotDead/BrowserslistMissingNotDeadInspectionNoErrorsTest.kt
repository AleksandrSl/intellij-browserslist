package inspections.MissingNotDead

import com.github.aleksandrsl.intellijbrowserslist.inspections.BrowserslistMissingNotDeadInspection
import inspections.BaseInspectionNoErrorsTestCase
import inspections.Inspection


class BrowserslistMissingNotDeadInspectionNoErrorsTest : BaseInspectionNoErrorsTestCase(
    Inspection(BrowserslistMissingNotDeadInspection(), "MissingNotDead"),
) {

    fun testSingleExpression() = doTest()
    fun testMultipleExpressions() = doTest()
    fun testMuchLater() = doTest()
}
