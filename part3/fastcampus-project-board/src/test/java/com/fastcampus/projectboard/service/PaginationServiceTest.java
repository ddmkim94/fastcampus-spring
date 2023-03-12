package com.fastcampus.projectboard.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * classes 속성을 통해서 테스트 시 빈을 생성할 클래스들을 지정할 수 있다. <br>
 * classes 속성을 생략하는 경우 @SpringBootApplication 하위 패키지에 정의된 모든 빈을 생성한다. <br>
 * webEnvironment NONE 속성은 웹 환경을 제공안하게 설정하는 옵션이다. <br>
 * 테스트의 무게를 줄이기 위해 2가지 속성을 부여해서 진행했다. <br>
 */
@DisplayName("비즈니스 로직 - 페이지네이션")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = PaginationService.class)
class PaginationServiceTest {

    private final PaginationService sut;

    public PaginationServiceTest(@Autowired PaginationService paginationService) {
        this.sut = paginationService;
    }

    @DisplayName("현재 페이지 번호와 총 페이지 수를 주면, 페이징 바 리스트를 반환한다.")
    @MethodSource("paginationTest")
    @ParameterizedTest(name = "[{index}] 현재 페이지: {0}, 전체 페이지: {1} => 페이지 바 리스트: {2}")
    void givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnPaginationBarNumbers(int currentPageNumber, int totalPages, List<Integer> expected) {

        // Given

        // When
        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber, totalPages);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    /** 필독!!
     * @MethodSource 는 Stream 을 반환하는 static 메서드로 작성해주면 됩니다.
     * 메서드 이름을 테스트 이름과 똑같이하면 자동으로 인식합니다.
     * 근데 테스트 메서드 이름이 너무 길어서 @MethodSource 에 이름 옵션을 줘서 짧은 메서드 이름을 가져갔습니다.
     */
    static Stream<Arguments> paginationTest() {
        return Stream.of(
                arguments(0, 13, List.of(0, 1, 2, 3, 4)),
                arguments(1, 13, List.of(0, 1, 2, 3, 4)),
                arguments(2, 13, List.of(0, 1, 2, 3, 4)),
                arguments(3, 13, List.of(1, 2, 3, 4, 5)),
                arguments(4, 13, List.of(2, 3, 4, 5, 6)),
                arguments(5, 13, List.of(3, 4, 5, 6, 7)),
                arguments(6, 13, List.of(4, 5, 6, 7, 8)),
                arguments(10, 13, List.of(8, 9, 10, 11, 12)),
                arguments(11, 13, List.of(9, 10, 11, 12)),
                arguments(12, 13, List.of(10, 11, 12))
        );
    }

    /**
     * 페이지네이션 바의 길이가 5 라는 점을 테스트 코드에서 드러내고 싶어서 추가했다.
     */
    @DisplayName("현재 설정되어 있는 페이지네이션 바의 길이는 5이다.")
    @Test
    void givenNothing_whenCalling_thenReturnsCurrentBarLength() {
        // Given

        // When
        int barLength = sut.currentBarLength();

        // Then
        assertThat(barLength).isEqualTo(5);
    }

}