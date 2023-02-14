package calculator;

import calculator.calculate.*;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> operators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return operators.stream()
                .filter(o -> o.supports(operator))
                .map(o -> o.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다!"));
    }
}
