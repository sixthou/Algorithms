package codility;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxProductOfThree2 {
    public int solution(int[] A) {
        Arrays.sort(A);
        int first = A[0] * A[1] * A[A.length - 1];
        int second = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

        return Math.max(first, second);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int expect) {
        Assertions.assertThat(solution(A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60),
                Arguments.of(new int[]{-3, 1, 2, -6, 5, 6}, 108)
        );
    }
}
