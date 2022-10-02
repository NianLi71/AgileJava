package sis.report;

import junit.framework.TestSuite;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.DateUtilTest;
import sis.studentinfo.StudentTest;

public class AllTests {
    public static TestSuite suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(RosterReporterTest.class);

        return suite;
    }
}
