package sis.studentinfo;

import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest extends TestCase {
    protected Session session;

    protected static final int CREDITS = 3;

    private Date startDate;

    public void setUp() {
        startDate = createDate(2003, 1, 6);
        session = createSession("ENGL","101", startDate);
        session.setNumberOfCredits(CREDITS);
    }

    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    public void testEnrollStudents() {
        Student student1 = new Student("Cain Divoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());

        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }

    public void testComparable() {
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create("CMSC", "101", date);
        CourseSession sessionB = CourseSession.create("ENGL", "101", date);

        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        CourseSession sessionC = CourseSession.create("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));

        CourseSession sessionD = CourseSession.create("CMSC", "210", date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }

    public void testIterate() {
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));

        List<Student> results = new ArrayList<>();
        for (Student student: session) {
            results.add(student);
        }
        assertEquals(session.getAllStudents(), results);
    }

    public void testSessionUrl() throws SessionException {
        final String url = "http://course.langsoft.com/cmsc300";

        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }

    public void testInvalidSessionUrl() {
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try {
            session.setUrl(url);
            fail("expected exception due to invalid protocol in URL");
        } catch (SessionException e) {
            Throwable cause = e.getCause();
            assertEquals(MalformedURLException.class, cause.getClass());
        }
    }

    abstract protected Session createSession(String department, String number, Date startDate);
}
