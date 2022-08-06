package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_81301 {

    public int solution(String s) {
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        s = s.replaceAll("zero", "0");
        return Integer.parseInt(s);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, int expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of("one4seveneight", 1478),
            Arguments.of("23four5six7", 234567),
            Arguments.of("2three45sixseven", 234567),
            Arguments.of("123", 123)
        );
    }

}
