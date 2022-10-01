package sis;

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(sis.report.AllTests.suite());
        suite.addTest(sis.studentinfo.AllTests.suite());

        return suite;
    }
}
