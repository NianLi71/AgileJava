package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CourseSession extends Session {
    private static int count = 0;
    public static CourseSession create(final Course course, final Date startDate) {
        return new CourseSession(course, startDate);
    }

    protected CourseSession(final Course course, final Date startDate) {
        super(course, startDate);
        CourseSession.incrementCount();
    }

    public static int getCount() {
        return count;
    }

    public static void resetCount() {
        count = 0;
    }

    private static void incrementCount() {
        count++;
    }

    @Override
    protected int getSessionLength() {
        return 16;
    }
}