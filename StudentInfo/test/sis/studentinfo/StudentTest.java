package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    private static final String STUDENT_IN_STATE = "CO";
    public void testCreate() {
        Student student = new Student("Jane Doe");
        String studentName = student.getName();
        assertEquals("Jane Doe", studentName);

        Student secondStudent = new Student("Joe Blow");
        String secondStudentName = secondStudent.getName();
        assertEquals("Joe Blow", secondStudentName);

        assertEquals("Jane Doe", student.getName());
    }

    public void testCredits() {
        Student student = new Student("a");
        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(5);
        assertEquals(12, student.getCredits());
        assertTrue(student.isFullTime());
    }

    public void testInState() {
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(STUDENT_IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }
}