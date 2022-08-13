package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_77884 {

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = cal(i);
            if (cnt % 2 == 0) {
                answer += i;
            }else{
                answer -= i;
            }
        }

        return answer;
    }

    int cal(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int m, int expect) {
        Assertions.assertThat(solution(n, m)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(13, 17, 43),
            Arguments.of(24, 27, 52)
        );
    }

}
