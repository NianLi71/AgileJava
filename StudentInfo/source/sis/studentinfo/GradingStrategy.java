package sis.studentinfo;

public interface GradingStrategy {
    double getGradePointsFor(final Student.Grade grade);
}
