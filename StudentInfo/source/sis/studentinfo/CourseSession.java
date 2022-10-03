package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CourseSession implements Comparable<CourseSession> {
    private static int count = 0;
    private String department;

    private String number;

    private ArrayList<Student> students = new ArrayList<>();

    private Date startDate;

    private int numberOfCredits;

    private CourseSession(final String department, final String number, final Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
        this.numberOfCredits = 0;
        CourseSession.incrementCount();
    }

    public static CourseSession create(final String department, final String number, final Date startDate) {
        return new CourseSession(department, number, startDate);
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


    public String getDepartment() {
        return this.department;
    }

    public String getNumber() {
        return this.number;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(final Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    public Student get(final int index) {
        return students.get(index);
    }

    public ArrayList<Student> getAllStudents() {
        return this.students;
    }

    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @return Date the last date of the course session
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;

        int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    public void setNumberOfCredits(int credits) {
        this.numberOfCredits = credits;
    }

    @Override
    public int compareTo(final CourseSession session) {
        if (this.getDepartment().equals(session.getDepartment())) {
            return this.getNumber().compareTo(session.getNumber());
        } else {
            return getDepartment().compareTo(session.getDepartment());
        }
    }
}