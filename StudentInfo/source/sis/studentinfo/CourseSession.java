package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CourseSession extends Session {
    private static int count = 0;
    public static CourseSession create(final String department, final String number, final Date startDate) {
        return new CourseSession(department, number, startDate);
    }

    protected CourseSession(final String department, final String number, final Date startDate) {
        super(department, number, startDate);
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