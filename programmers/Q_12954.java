package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12954 {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long temp = x;

        for (int i = 0; i < n; i++) {
            answer[i] = temp;
            temp += x;
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution_2(int x, int n, long[] expect) {
        Assertions.assertThat(solution(x, n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(2, 5, new long[] {2, 4, 6, 8, 10}),
            Arguments.of(4, 3, new long[]{4, 8, 12}),
            Arguments.of(-4, 2, new long[]{-4, -8})
        );
    }
}
