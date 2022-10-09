

package sis.studentinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Student implements Serializable {

    final static Logger logger = Logger.getLogger(Student.class.getName());
    private static final String STUDENT_IN_STATE = "CO";
    private final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    private final String fullName;

    private String firstName = "";
    private String middleName = "";
    private String lastName = "";

    private int credits = 0;

    private String state = "";

    private String id;

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

    public static Student findByLastName(String lastName) {
        // just an example
        return new Student(lastName);
    }

    public Student(String fullName) {
        this(fullName, new BasicGradingStrategy());
    }

    public Student(String fullName, final GradingStrategy gradingStrategy) {
        this.fullName = fullName;
        this.gradingStrategy = gradingStrategy;

        List<String> nameParts = split(fullName);
        final int maximumNumberOfNameParts = 3;
        if (nameParts.size() > maximumNumberOfNameParts) {
            StringBuilder builder = new StringBuilder();
            builder.append("Student name ")
                    .append("'").append(fullName).append("'")
                    .append(" contains more than ").append(maximumNumberOfNameParts).append(" parts");
            String message = builder.toString();
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
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

    private void setName(List<String> nameParts) {
        if (nameParts.size() == 1) {
            this.lastName = nameParts.get(0);
        } else if (nameParts.size() == 2) {
            this.firstName = nameParts.get(0);
            this.lastName = nameParts.get(1);
        } else if (nameParts.size() == 3) {
            this.firstName = nameParts.get(0);
            this.middleName = nameParts.get(1);
            this.lastName = nameParts.get(2);
        }
    }

    private List<String> split(String fullName) {
        final String[] parts = fullName.split(" ");
        return Arrays.asList(parts);
    }

    @Override
    public String toString() {
        return String.format("Student, id: %s", id);
    }
}