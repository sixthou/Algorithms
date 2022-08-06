package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_86491 {


    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] size : sizes) {
            w = Math.max(Math.max(size[0], size[1]), w);
            h = Math.max(Math.min(size[0], size[1]), h);

        }
        return w * h;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[][] sizes, int expect) {
        Assertions.assertThat(solution(sizes)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}, 4000),
            Arguments.of(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}, 120),
            Arguments.of(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}, 133)
        );
    }

}
