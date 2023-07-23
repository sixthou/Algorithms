package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q0027 {
    /**
     * 제공자 : leetcode
     * 제목 : Remove Element
     * URL : https://leetcode.com/problems/remove-element/description/
     * 난이도 : easy
     * 유형 :
     * 설명 :
     * 예외 : 중복된것을 제외한 길이를 구하는 문제로 알고 했으나, 별도의 테스트가 존재해서 해답 기준에 맞추는데 어려움이 있었다.
     **/

    public int solution(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] nums, int val, int[] expect) {
        Assertions.assertThat(solution(nums, val)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 4, 0, 3})
        );
    }

}
