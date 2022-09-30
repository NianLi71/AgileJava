
/*
javac -cp :$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar CourseSessionTest.java;\
java -cp .:$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar junit.awtui.TestRunner CourseSessionTest
 */

import java.util.ArrayList;

public class CourseSessionTest extends junit.framework.TestCase {
    public void testCreate() {
        CourseSession session = new CourseSession("ENGL", "101");
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollStudents() {
        CourseSession session = new CourseSession("ENGL", "101");

        Student student1 = new Student("Cain Divoe");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        ArrayList<Student> allStudents = session.getAllStudents();
        assertEquals(1, allStudents.size());

        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(2, allStudents.size());

        assertEquals(student1, allStudents.get(0));
        assertEquals(student2, allStudents.get(1));
    }
}