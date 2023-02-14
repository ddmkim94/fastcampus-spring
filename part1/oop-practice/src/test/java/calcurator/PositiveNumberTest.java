package calcurator;

import calcurator.calculate.PositiveNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -11, -152})
    public void positiveNumberTest(int num) throws Exception {
        assertThatCode(() -> new PositiveNumber(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수를 전달할 수 없습니다!");
    }

}