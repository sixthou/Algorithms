package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TapeEquilibrium2 {

    public int solution(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;

        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }

        int minimumGap = Math.abs(leftSum - rightSum);

        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            if (Math.abs(leftSum - rightSum) < minimumGap) {
                minimumGap = Math.abs(leftSum - rightSum);
            }
        }

        return minimumGap;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int expect) {
        Assertions.assertThat(solution(A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 4, 3}, 1),
                Arguments.of(new int[]{-1000, 1000}, 2000));
    }
}
