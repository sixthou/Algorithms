package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_120956 {

    public int solution(String[] babbling) {
        int answer = 0;
        for (String temp : babbling) {
            temp = temp.replaceAll("aya", "000");
            temp = temp.replaceAll("ye", "00");
            temp = temp.replaceAll("woo", "000");
            temp = temp.replaceAll("ma", "00");
            temp = temp.replaceAll("0", "");
            if (temp.equals("")) {
                answer++;
            }
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] babbling, int expect) {
        Assertions.assertThat(solution(babbling)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}, 3),
                Arguments.of(new String[]{"yee", "aya", "u", "maa", "wyeoo"}, 1)
        );
    }
}
