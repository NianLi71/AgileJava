package studentinfo;

public class StudentTest extends junit.framework.TestCase {
    public void testCreate() {
        Student student = new Student("Jane Doe");
        String studentName = student.getName();
        assertEquals("Jane Doe", studentName);

        Student secondStudent = new Student("Joe Blow");
        String secondStudentName = secondStudent.getName();
        assertEquals("Joe Blow", secondStudentName);

        assertEquals("Jane Doe", student.getName());
    }
}