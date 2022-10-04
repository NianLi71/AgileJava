package sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

abstract public class Session implements Comparable<Session> {
    private String department;

    private String number;

    private ArrayList<Student> students = new ArrayList<>();

    private Date startDate;

    private int numberOfCredits;

    protected Session(final String department, final String number, final Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
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

    protected Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @return Date the last date of the course session
     */
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());

        final int sessionLength = getSessionLength();
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
    public int compareTo(final Session session) {
        if (this.getDepartment().equals(session.getDepartment())) {
            return this.getNumber().compareTo(session.getNumber());
        } else {
            return getDepartment().compareTo(session.getDepartment());
        }
    }

    abstract protected int getSessionLength();
}
