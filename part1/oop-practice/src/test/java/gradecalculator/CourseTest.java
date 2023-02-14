package gradecalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {

    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void createCourseTest() throws Exception {
        // 해당 코스가 정상적으로 생성된 경우 어떤 예외도 발생하지 않는다.
        assertThatCode(() -> new Course("OOP", 3, "A+"))
                .doesNotThrowAnyException();
    }
}
