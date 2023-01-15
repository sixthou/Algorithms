package codility;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MissingInteger2 {

    public int solution(int[] A) {
        int answer = 1;
        Arrays.sort(A);
        for (int num : A) {
            if (num < answer) {
                continue;
            }
            if (num == answer) {
                answer++;
            }
        }

        return answer;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int expect) {
        Assertions.assertThat(solution(A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 6, 4, 2}, 5),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{-1, -3},1)
        );
    }
}
