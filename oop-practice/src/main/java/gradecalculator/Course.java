package gradecalculator;

public class Course {

    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }
}
