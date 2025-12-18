package inspections.MissingNotDead

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistBundle
import com.github.aleksandrsl.intellijbrowserslist.inspections.BrowserslistMissingNotDeadInspection
import inspections.BaseInspectionQuickFixTestCase
import inspections.Inspection
import inspections.QuickFix


class BrowserslistMissingNotDeadInspectionMoveNotDeadTest : BaseInspectionQuickFixTestCase(
    Inspection(BrowserslistMissingNotDeadInspection(), "MissingNotDead"),
    QuickFix(BrowserslistBundle.message("browserslist.inspection.missed.not.dead.move.use.quickfix"), "MoveNotDead")
) {
    fun testMultipleExpressions() = doTest()
    fun testInComplexExpression() = doTest()
}
