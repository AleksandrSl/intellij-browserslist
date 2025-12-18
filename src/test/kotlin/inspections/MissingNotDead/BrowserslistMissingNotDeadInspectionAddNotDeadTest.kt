package inspections.MissingNotDead

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistBundle
import com.github.aleksandrsl.intellijbrowserslist.inspections.BrowserslistMissingNotDeadInspection
import inspections.BaseInspectionQuickFixTestCase
import inspections.Inspection
import inspections.QuickFix


class BrowserslistMissingNotDeadInspectionAddNotDeadTest : BaseInspectionQuickFixTestCase(
    Inspection(BrowserslistMissingNotDeadInspection(), "MissingNotDead"),
    QuickFix(BrowserslistBundle.message("browserslist.inspection.missed.not.dead.add.use.quickfix"), "AddNotDead")
) {
    fun testSingleQuery() = doTest()
    fun testSingleExpression() = doTest()
    fun testMultipleExpressions() = doTest()
    fun testMultipleNotDead() = doTest()
    fun testMultipleSectionsConstrainedToScope1() = doTest()
    fun testMultipleSectionsConstrainedToScope2() = doTest()
    fun testMultipleSectionsConstrainedToScope3() = doTest()
}
