package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.CourseSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest extends TestCase {
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();

        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL","410", date));
        report.add(CourseSession.create("CZEC","220", date));
        report.add(CourseSession.create("ITAL","330", date));

//        System.out.println(report.text());
        assertEquals("CZEC 200" + NEWLINE +
                "CZEC 220" + NEWLINE +
                "ENGL 101" + NEWLINE +
                "ITAL 330" + NEWLINE +
                "ITAL 410" + NEWLINE, report.text());
    }

    public void testSortStringsInPlace() {
        final List<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");

        java.util.Collections.sort(list);

        assertEquals("Boyle", list.get(0));
        assertEquals("Camus", list.get(1));
        assertEquals("Heller", list.get(2));
        assertEquals("Kafka", list.get(3));
    }

    public void testSortStringsInNewList() {
        final List<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");

        final List<String> sortedList = new ArrayList<>(list);
        java.util.Collections.sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));

        // original list not changed
        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));
    }

    public void testStringCompareTo() {
        assertTrue("A".compareTo("B") < 0);
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
    }
}
