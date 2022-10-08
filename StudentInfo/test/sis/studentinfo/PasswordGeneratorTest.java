package sis.studentinfo;

import junit.framework.TestCase;

public class PasswordGeneratorTest extends TestCase {
    public void testGeneratorPassword() {
        PasswordGenerator generator = new PasswordGenerator();
        generator.setRandom(new MockRandom('A'));
        assertEquals("ABCDEFGH", generator.generatePassword());
        generator.setRandom(new MockRandom('C'));
        assertEquals("CDEFGHIJ", generator.generatePassword());
    }

    class MockRandom extends java.util.Random {
        private int i;
        MockRandom(char startCharValue) {
            i = startCharValue - PasswordGenerator.LOW_END_PASSWORD_CHAR;
        }

        @Override
        protected int next(int bits) {
            return i++;
        }
    }
}
