package calcurator.calculate;

public interface NewArithmeticOperator {
    // 해당 연산자를 지원하는지 검사
    boolean supports(String operator);
    int calculate(int operand1, int operand2);
}
