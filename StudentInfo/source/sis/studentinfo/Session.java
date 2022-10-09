package sis.studentinfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

abstract public class Session implements Comparable<Session>, Iterable<Student>, Serializable {
    public static final long serialVersionUID = 1L;
    private Course course;
    private transient List<Student> students = new ArrayList<>();

    private Date startDate;

    private int numberOfCredits;

    private URL url;

    protected Session(final Course course, final Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }

    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
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

    public List<Student> getAllStudents() {
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

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public void setUrl(String url) throws SessionException {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    private void log(Exception e) {
        e.printStackTrace();
    }

    public URL getUrl() {
        return url;
    }

    abstract protected int getSessionLength();

    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        output.writeInt(students.size());
        for (Student student: students) {
            output.writeObject(student.getLastName());
        }
    }

    private void readObject(ObjectInputStream input) throws Exception {
        input.defaultReadObject();
        students = new ArrayList<Student>();
        int size = input.readInt();
        for (int i = 0; i < size; i++) {
            String lastName = (String)input.readObject();
            students.add(Student.findByLastName(lastName));
        }
    }
}
