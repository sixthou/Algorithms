package programmers;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12939 {

    public String solution(String s) {
        String[] strings = s.split(" ");

        String max = String.valueOf(Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt());

        String min = String.valueOf(Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt());

        return min + " " + max;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, String expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }
    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("1 2 3 4", "1 4"),
                Arguments.of("-1 -2 -3 -4", "-4 -1"),
                Arguments.of("-1 -1", "-1 -1")
        );
    }
}
