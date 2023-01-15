package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BinaryGap2 {
    public int solution(int N) {
        int maxNum = 0;
        String binaryString = Integer.toBinaryString(N);

        if (N <= 3) {
            return 0;
        }

        int now = 0;

        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (now > maxNum) {
                    maxNum = now;
                }
                now = 0;
                continue;
            }
            now++;
        }
        return maxNum;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int N, int expect) {
        Assertions.assertThat(solution(N)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(1041, 5),
                Arguments.of(32, 0),
                Arguments.of(20, 1)
        );
    }
}
