package inspections

import com.intellij.codeInspection.InspectionProfileEntry
import com.intellij.testFramework.fixtures.BasePlatformTestCase

data class Inspection(val inspection: InspectionProfileEntry, val key: String)

abstract class BaseInspectionTestCase(
    private val inspection: Inspection,
) :
    BasePlatformTestCase() {

    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()
        // Well, sometime I'll come up with a good name
        myFixture.enableInspections(inspection.inspection)
    }

    protected override fun getTestDataPath(): String {
        return "src/test/testData/inspections/${inspection.key}"
    }
}
