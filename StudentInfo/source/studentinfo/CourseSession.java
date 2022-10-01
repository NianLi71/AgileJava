package studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CourseSession {
    private String department;

    private String number;

    private ArrayList<Student> students = new ArrayList<>();

    private Date startDate;

    public CourseSession(final String department, final String number) {
        this.department = department;
        this.number = number;
    }

    public CourseSession(final String department, final String number, final Date startDate) {
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
}