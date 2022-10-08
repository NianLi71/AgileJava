package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import junit.framework.TestCase;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static sis.studentinfo.DateUtil.createDate;

public class CourseSessionTest extends SessionTest {
    public void testCount() {
        CourseSession.resetCount();
        createSession(new Course("",""), new Date());
        assertEquals(1, CourseSession.getCount());
        createSession(new Course("",""), new Date());
        assertEquals(2, CourseSession.getCount());
    }

    public void testCourseDates() {
        Date startDate = createDate(2003, 1, 6);
        session = createSession(new Course("ENGL","101"), startDate);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Override
    protected Session createSession(Course course, Date startDate) {
        return CourseSession.create(course, startDate);
    }
}