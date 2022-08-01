package programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_86051 {

    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> nums = Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toSet());

        for (int i = 1; i <= 9; i++) {
            if (!nums.contains(i)) {
                answer += i;
            }
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] numbers, int expect) {
        Assertions.assertThat(solution(numbers)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 6, 7, 8, 0}, 14),
            Arguments.of(new int[]{5, 8, 4, 0, 6, 7, 9}, 6)
        );
    }

}
