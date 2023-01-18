package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12951 {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (!flag) {
                answer.append(Character.toString(s.charAt(i)).toLowerCase());
            }

            if (flag) {
                answer.append(Character.toString(s.charAt(i)).toUpperCase());
                flag = false;
            }

            if (s.charAt(i) == ' ') {
                flag = true;
            }
        }
        return answer.toString();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, String expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("3people unFollowed me", "3people Unfollowed Me"),
                Arguments.of("for the last week", "For The Last Week")
        );
    }
}
