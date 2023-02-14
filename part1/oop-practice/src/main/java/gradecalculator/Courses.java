package gradecalculator;

import java.util.List;

public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndCourseGrade = 0;

        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndGrade();
        }

        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();
    }
}
