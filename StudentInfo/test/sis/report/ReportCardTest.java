package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.Student;

import java.util.*;

public class ReportCardTest extends TestCase {

    private ReportCard card;

    protected void setUp() {
        this.card = new ReportCard();
    }
    public void testMessage() {
        assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
    }

    public void testKeys() {
//        Map<String, String> m = new HashMap<>();
//        m.put("hello", "world");
//
//        Map<String, String> m2 = new HashMap<>();
//        m2.put("hello", "world");
//
//        assertTrue(m != m2); // diff in memory position
//        assertTrue(m.equals(m2));

        Set<Student.Grade> expectedGrades = EnumSet.allOf(Student.Grade.class);

        Set<Student.Grade> grades = EnumSet.noneOf(Student.Grade.class);
//        Set<Student.Grade> grades = new HashSet<>();
        for (Student.Grade grade: card.getMessages().keySet()) {
            grades.add(grade);
        }

        assertEquals(expectedGrades, grades);
        assertTrue(expectedGrades != grades);  // diff in memory position
    }

    public void testValues() {
        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add(ReportCard.A_MESSAGE);
        expectedMessages.add(ReportCard.B_MESSAGE);
        expectedMessages.add(ReportCard.C_MESSAGE);
        expectedMessages.add(ReportCard.D_MESSAGE);
        expectedMessages.add(ReportCard.F_MESSAGE);

        Collection<String> messages = card.getMessages().values();
        for (String message: messages) {
            assertTrue(expectedMessages.contains(message));
        }
        assertEquals(expectedMessages.size(), messages.size());
    }

    public void testEntries() {
//        final Set<Map.Entry> entries = new HashSet<>(card.getMessages().entrySet());

        Set<Entry> entries = new HashSet<>();
        for (Map.Entry<Student.Grade, String> entry: card.getMessages().entrySet()) {
            entries.add(new Entry(entry.getKey(), entry.getValue()));
        }

        Set<Entry> expectedEntries = new HashSet<>();
        expectedEntries.add(new Entry(Student.Grade.A, ReportCard.A_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.B, ReportCard.B_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.C, ReportCard.C_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.D, ReportCard.D_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.F, ReportCard.F_MESSAGE));

        assertEquals(expectedEntries, entries);
    }

    class Entry {
        private final Student.Grade grade;
        private final String message;

        Entry(Student.Grade grade, String message) {
            this.grade = grade;
            this.message = message;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            Entry that = (Entry)obj;
            return this.grade == that.grade && this.message == that.message;
        }

        @Override
        public int hashCode() {
            return 1;
        }

//        @Override
//        public int hashCode() {
//            final int hashMultipler = 41;
//            int result = 7;
//            result = result * hashMultipler + grade.hashCode();
//            result = result * hashMultipler + message.hashCode();
//            return result;
//        }
    }

}
