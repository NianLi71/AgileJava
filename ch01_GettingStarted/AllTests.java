
/*
javac -cp :$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar AllTests.java;\
java -cp .:$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar junit.awtui.TestRunner AllTests
 */

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);

        return suite;
    }
}