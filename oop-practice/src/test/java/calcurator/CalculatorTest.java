package calcurator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 요구 사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() throws Exception {
        int result = Calculator.calculate(1, "+", 2);

        Assertions.assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTest() throws Exception {
        int result = Calculator.calculate(1, "-", 2);

        Assertions.assertThat(result).isEqualTo(-1);
    }
}
