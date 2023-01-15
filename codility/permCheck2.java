package codility;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class permCheck2 {

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int expect) {
        Assertions.assertThat(solution(A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 3, 2}, 1),
                Arguments.of(new int[]{4, 1, 3}, 0)
        );
    }
}
