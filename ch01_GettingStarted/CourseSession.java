
import java.util.ArrayList;

public class CourseSession {

    private String department;

    private String number;

    private ArrayList<Student> students = new ArrayList<>();

    public CourseSession(final String department, final String number) {
        this.department = department;
        this.number = number;
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

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}