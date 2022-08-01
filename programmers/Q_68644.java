package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_68644 {

    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution_2(int[] x, int[] expect) {
        Assertions.assertThat(solution(x)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{2, 1, 3, 4, 1}, new int[]{2, 3, 4, 5, 6, 7}),
            Arguments.of(new int[]{5, 0, 2, 7}, new int[]{2, 5, 7, 9, 12})
        );
    }
}
