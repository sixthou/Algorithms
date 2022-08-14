package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12934 {

    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        if (Math.pow(sqrt, 2) == n) {
            return (long) Math.pow(sqrt + 1, 2);
        }
        return -1;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution( long n, long expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(121,144),
            Arguments.of(3, -1)
        );
    }

}
