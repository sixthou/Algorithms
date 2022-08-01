package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12930 {

    public String solution(String s) {
        String answer = "";
        int indexCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, i + 1);
            if (tmp.equals(" ")) {
                indexCnt = 0;
                answer += tmp;
                continue;
            }
            if (indexCnt % 2 == 0) {
                answer += tmp.toUpperCase();
            }
            if (indexCnt % 2 == 1) {
                answer += tmp.toLowerCase();
            }
            indexCnt++;

        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String x, String expect) {
        Assertions.assertThat(solution(x)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of("try hello world", "TrY HeLlO WoRlD")
        );
    }

}
