package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_87389 {

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int x, int expect) {
        Assertions.assertThat(solution(x)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(10, 3),
            Arguments.of(12, 11)

        );
    }


}
