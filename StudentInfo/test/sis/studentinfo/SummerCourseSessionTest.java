package sis.studentinfo;

import junit.framework.TestCase;

import java.util.Date;

public class SummerCourseSessionTest extends SessionTest {
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession( new Course("ENGL", "200"), startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }

    @Override
    protected Session createSession(Course course, Date startDate) {
        return SummerCourseSession.create(course, startDate);
    }
}
