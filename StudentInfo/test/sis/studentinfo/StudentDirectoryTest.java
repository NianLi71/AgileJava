package sis.studentinfo;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class StudentDirectoryTest extends TestCase {
    private StudentDirectory dir;

    protected void setUp() {
        dir = new StudentDirectory();
    }

    public void testStoreAndRetrieve() throws IOException {
        final int numberOfStudent = 10;
        for (int i = 0; i < numberOfStudent; i++) {
            addStudent(dir, i);
        }

        for (int i = 0; i < numberOfStudent; i++) {
            verifyStudentLookUp(dir, i);
        }
    }

    private void addStudent(StudentDirectory dir, int i) {
        String id = "" + i;
        Student student = new Student(id);
        student.setId(id);
        student.addCredits(i);
//        System.out.println(student);
        dir.add(student);
    }

    private void verifyStudentLookUp(StudentDirectory dir, int i) {
        String id = "" + i;
        Student student = dir.findById(id);
        System.out.println(student);
        assertEquals(id, student.getLastName());
        assertEquals(id, student.getId());
        assertEquals(i, student.getCredits());
    }
}
