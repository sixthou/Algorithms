package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12899 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 124 나라의 숫자
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12899#qna
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 이런 문제가 젤 어렵다...
     * 예외 :
     **/
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 3 == 0) {
                sb.append("4");
                n = n / 3 - 1;
            } else {
                sb.append(n % 3);
                n = n / 3;
            }
        }
        return sb.reverse().toString();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, String expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(1,	"1"),
                Arguments.of(6,	"14"),
                Arguments.of(2,	"2"),
                Arguments.of(7,	"21"),
                Arguments.of(3,	"4"),
                Arguments.of(8,	"22"),
                Arguments.of(4,	"11"),
                Arguments.of(9,	"24"),
                Arguments.of(5,	"12"),
                Arguments.of(10,	"41")
        );
    }
}
