package sis.studentinfo;

import java.io.Serializable;

public class HonorsGradingStrategy extends BasicGradingStrategy implements Serializable {

    @Override
    public double getGradePointsFor(Student.Grade grade) {
        double points = super.getGradePointsFor(grade);
        if (points > 0) {
            points += 1.0;
        }
        return points;
    }
}
