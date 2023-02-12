package gradecalculator;

import java.util.List;

public class GradeCalculator {

    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 평균 학점 계산 방법 = (학점수 * 교과목 평점) / 수강신청 총학점 수
     */
    public double calculateGrade() {
        double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
        }

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();

        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
