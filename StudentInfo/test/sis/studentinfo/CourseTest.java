package sis.studentinfo;

import junit.framework.TestCase;

import java.util.*;

public class CourseTest extends TestCase {
    public void testCreate() {
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }

    public void testEquality() {
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");
        assertEquals(courseA, courseAPrime);

        Course courseB = new Course("ARTH", "300");
        assertFalse(courseA.equals(courseB));

        //reflexivity
        assertEquals(courseA, courseA); //x.equals(x)

        // transitivity
        Course courseAPrime2 = new Course("NURS", "201");
        assertEquals(courseAPrime, courseAPrime2);
        assertEquals(courseA, courseAPrime2);

        // symmetry
        assertEquals(courseAPrime, courseA);

        // consistency
        assertEquals(courseA, courseAPrime);

        // comparison to null
        assertFalse(courseA.equals(null));

        assertFalse(courseA.equals("hello"));

        List<Course> list = new ArrayList<>();
        list.add(courseA);
        list.contains(courseA);  // use o.equals() to check
    }

    public void testHashCode() {
        Course courseA = new Course("NURS", "201");
        Course courseAPrime = new Course("NURS", "201");

        Map<Course, String> map = new HashMap<>();
        map.put(courseA, "");
        assertTrue(map.containsKey(courseAPrime));

        assertEquals(courseA.hashCode(), courseAPrime.hashCode());
        // consistency
        assertEquals(courseA.hashCode(), courseA.hashCode());
    }

    public void testHashCodePerformance() {
        final int count = 10000;

        long start = System.currentTimeMillis();
        final Map<Course, String> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            Course course = new Course("C" + i, "" + i);
            map.put(course, "");
        }

        long stop = System.currentTimeMillis();
        long elapsed = stop - start;
        final long arbitraryThreshold = 200;
        assertTrue("elapsed time = " + elapsed, elapsed < arbitraryThreshold);
    }

    public void testToString() {
        Course course = new Course("ENGL", "301");
        assertEquals("ENGL 301", course.toString());
    }
}
