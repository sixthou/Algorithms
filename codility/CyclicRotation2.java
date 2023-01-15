package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CyclicRotation2 {
    public int[] solution(int[] A, int K) {
        int[] answer = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            answer[(K + i) % A.length] = A[i];
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int K, int[] expect) {
        Assertions.assertThat(solution(A, K)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 0, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, 1, new int[]{2, 1}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, 3, new int[]{2, 1}),
                Arguments.of(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8})
        );
    }

}
