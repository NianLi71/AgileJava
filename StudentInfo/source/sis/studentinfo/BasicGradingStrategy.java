package sis.studentinfo;

public class BasicGradingStrategy implements GradingStrategy {
    public double getGradePointsFor(Student.Grade grade) {
        return grade.getPoints();
    }
}
