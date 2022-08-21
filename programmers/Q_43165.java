package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_43165 {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] numbers, int target, int expect) {
        Assertions.assertThat(solution(numbers, target)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        Stream<Arguments> of = Stream.of(
            Arguments.of(new int[]{1, 1, 1, 1, 1}, 3, 5),
            Arguments.of(new int[]{4, 1, 2, 1}, 4, 2)
        );
        return of;
    }

}
