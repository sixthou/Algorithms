package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12977 {

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    boolean isPrime(int num) {
        int primeCnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                primeCnt++;
            }
        }
        return primeCnt == 2;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] nums, int expect) {
        Assertions.assertThat(solution(nums)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4}, 1),
            Arguments.of(new int[]{1, 2, 3}, 0),
            Arguments.of(new int[]{1, 2, 7, 6, 4}, 4)
        );
    }

}
