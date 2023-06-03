package leetcode;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q1822 {
    public int arraySign(int[] nums) {
        int negative = 0;

        for(int num : nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                negative++;
            }
        }

        return negative % 2 == 0 ? 1 : -1;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] nums, int expect) {
        Assertions.assertThat(arraySign(nums)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(),
                Arguments.of(new int[]{9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24}, -1),
                Arguments.of(
                        new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43,
                                83,
                                78, 82, 70, 15, -41}, -1)
        );
    }
}
