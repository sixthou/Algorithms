package programmers;

import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_1845 {

    public int solution(int[] nums) {
        int length = nums.length / 2;
        int count = (int) Arrays.stream(nums).distinct().count();
        return Math.min(length, count);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] nums, int expect) {
        Assertions.assertThat(solution(nums)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{3,1,2,3},2),
            Arguments.of(new int[]{3,3,3,2,2,4},3),
            Arguments.of(new int[]{3,3,3,2,2,2},2)
        );
    }

}
