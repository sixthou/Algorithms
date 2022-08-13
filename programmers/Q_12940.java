package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12940 {

    public int[] solution(int n, int m) {

        return new int[]{gcd(n, m), lcm(n, m)};
    }



    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(a, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int m, int[] expect) {
        Assertions.assertThat(solution(n, m)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(3, 12, new int[]{3, 12}),
            Arguments.of(2, 5, new int[]{1, 10})
        );
    }

}
