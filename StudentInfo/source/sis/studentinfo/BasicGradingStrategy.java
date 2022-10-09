package sis.studentinfo;

import java.io.Serializable;

public class BasicGradingStrategy implements GradingStrategy, Serializable {
    public double getGradePointsFor(Student.Grade grade) {
        return grade.getPoints();
    }
}
