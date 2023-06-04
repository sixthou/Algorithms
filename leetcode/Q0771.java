package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q0771 {
    /**
     * 제공자 : leetCode
     * 제목 : jewels-and-stones
     * URL : https://leetcode.com/problems/jewels-and-stones/
     * 난이도 : easy
     * 유형 :
     * 설명 :
     * 예외 :
     **/

    public int numJewelsInStones(String jewels, String stones) {
        Set<String> jewelSet = Arrays.stream(jewels.split(""))
                .collect(Collectors.toSet());

        return (int)Arrays.stream(stones.split(""))
                .filter(s -> jewelSet.contains(s))
                .count();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String jewels, String stones, int expect) {
        Assertions.assertThat(numJewelsInStones(jewels, stones)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("aA", "aAAbbbbbbb", 3),
                Arguments.of("aA", "ZZ", 0)
        );
    }

}
