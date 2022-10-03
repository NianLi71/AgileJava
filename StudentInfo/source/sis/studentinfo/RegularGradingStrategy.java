package sis.studentinfo;

public class RegularGradingStrategy implements GradingStrategy {
    @Override
    public double getGradePointsFor(Student.Grade grade) {
        if (grade.equals(Student.Grade.A)) return 4.0;
        if (grade.equals(Student.Grade.B)) return 3.0;
        if (grade.equals(Student.Grade.C)) return 2.0;
        if (grade.equals(Student.Grade.D)) return 1.0;
        return 0.0;
    }
}
