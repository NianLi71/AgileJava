package sis.studentinfo;

public class HonorsGradingStrategy implements GradingStrategy {
    private final GradingStrategy basicGradingStrategy;

    public HonorsGradingStrategy() {
        this.basicGradingStrategy = new RegularGradingStrategy();
    }
    @Override
    public double getGradePointsFor(Student.Grade grade) {
        double points = this.basicGradingStrategy.getGradePointsFor(grade);
        if (points > 0) {
            points += 1.0;
        }
        return points;
    }
}
