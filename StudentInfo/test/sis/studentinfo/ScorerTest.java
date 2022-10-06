package sis.studentinfo;

import junit.framework.TestCase;

public class ScorerTest extends TestCase {
    public void testCaptureScore() {
        Scorer scorer = new Scorer();
        assertEquals(75, scorer.score("75"));
    }

    public void testIsValid() {
        Scorer scorer = new Scorer();
        assertTrue(scorer.isValid("75"));
        assertFalse(scorer.isValid("abd"));
    }
}
