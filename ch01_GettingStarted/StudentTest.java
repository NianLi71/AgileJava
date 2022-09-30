

/*
javac -cp :$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar StudentTest.java;\
java -cp .:$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar junit.awtui.TestRunner StudentTest
 */

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