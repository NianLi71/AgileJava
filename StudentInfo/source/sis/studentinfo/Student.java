

package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static final String STUDENT_IN_STATE = "CO";
    private final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private final String name;

    private int credits = 0;

    private String state = "";

    private List<Grade> grades = new ArrayList<>();

    private GradingStrategy gradingStrategy;

    public enum Grade {
        A(4.0), B(3.0), C(2.0), D(1.0), F(0.0);

        private final double points;

        private Grade(double points) {
            this.points = points;
        }

        double getPoints() {
            return  points;
        }
    };

    public Student(String name) {
        this(name, new BasicGradingStrategy());
    }

    public Student(String name, final GradingStrategy gradingStrategy) {
        this.name = name;
        this.gradingStrategy = gradingStrategy;
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

    public double getGpa() {
        if (grades.isEmpty()) {
            return 0.0;
        } else {
            double gradeSum = 0.0;
            for (Grade grade: grades) {
                gradeSum += gradePointsFor(grade);
            }
            return gradeSum / grades.size();
        }
    }

    public void addGrade(final Grade grade) {
        this.grades.add(grade);
    }

    private double gradePointsFor(Grade grade) {
        return gradingStrategy.getGradePointsFor(grade);
    }
}