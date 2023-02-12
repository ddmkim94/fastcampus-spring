package gradecalculator;

import java.util.List;

public class GradeCalculator {

    // 일급 컬렉션
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 평균 학점 계산 방법 = (학점수 * 교과목 평점) / 수강신청 총학점 수
     */
    public double calculateGrade() {
        // (학점수 * 교과목 평점) 의 합계
        double totalMultiplyCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
        // 수강 신청한 과목의 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultiplyCreditAndCourseGrade / totalCompletedCredit;
    }
}
