package programmers;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12935 {

    public int[] solution(int[] arr) {
        if (arr.length <= 1) return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] arr1, int[] expect) {
        Assertions.assertThat(solution(arr1)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2}),
            Arguments.of(new int[]{10}, new int[]{-1})
        );
    }

}
