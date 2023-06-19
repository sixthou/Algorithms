package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q0347 {
    /**
     * 제공자 : leetCode
     * 제목 : 347. Top K Frequent Elements
     * URL : https://leetcode.com/problems/top-k-frequent-elements/
     * 난이도 : medium
     * 유형 : Map
     * 설명 :
     * 예외 :
     **/

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        return map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .mapToInt(Entry::getKey)
                .toArray();

    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] nums, int k, int[] expect) {
        Assertions.assertThat(topKFrequent(nums, k)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1})
        );
    }
}
