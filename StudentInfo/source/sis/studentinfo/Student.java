

package sis.studentinfo;

public class Student {
    private static final String STUDENT_IN_STATE = "CO";
    private final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private String name;

    private int credits;

    private String state = "";

    public Student(String name) {
        this.name = name;
        this.credits = 0;
    }

    public String getName() {
        return this.name;
    }

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(final int credits) {
        this.credits += credits;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isInState() {
        return state.equals(STUDENT_IN_STATE);
    }
}