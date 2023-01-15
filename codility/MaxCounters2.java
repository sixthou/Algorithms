package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxCounters2 {
    public int[] solution(int N, int[] A) {
        int[] answer = new int[N];
        int max = 0;
        int tmp = 0;

        for (int num : A) {
            if (num == N + 1) {
                max = tmp;
            } else {
                if (answer[num - 1] < max) {
                    answer[num - 1] = max;
                }
                answer[num - 1]++;
                if (answer[num - 1] > tmp) {
                    tmp = answer[num - 1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (answer[i] < max) {
                answer[i] = max;
            }
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int N, int[] A, int[] expect) {
        Assertions.assertThat(solution(N, A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2})
        );
    }
}
