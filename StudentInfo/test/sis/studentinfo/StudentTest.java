package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    private static final String STUDENT_IN_STATE = "CO";

    private static final double GRADE_TOLERANCE = 0.05;
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

    public void testCalculateGpa() {
        Student student = new Student("a");
        assertGpa(student, 0.0);

        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);

        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);

        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);

        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);

        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }

    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

    public void testCalculateHonorsStudentGpa() {
        assertGpa(createHonorsStudent(), 0.0);

        assertGpa(createHonorsStudentWithGrade(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudentWithGrade(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudentWithGrade(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudentWithGrade(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudentWithGrade(Student.Grade.F), 0.0);
    }

    private Student createHonorsStudentWithGrade(Student.Grade grade) {
        Student student = createHonorsStudent();
        student.addGrade(grade);
        return student;
    }
    private Student createHonorsStudent() {
        return new Student("a", new HonorsGradingStrategy());
    }

}