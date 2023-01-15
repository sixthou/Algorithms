package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CountDiv2 {

    public int solution(int A, int B, int K) {
        int front = A / K;
        int behind = B / K;

        if (A % K != 0) {
            front++;
        }
        return behind - front + 1;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int A, int B, int K, int expect) {
        Assertions.assertThat(solution(A, B, K)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(6, 11, 2, 3),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(1, 1, 2, 0)
        );
    }

}
