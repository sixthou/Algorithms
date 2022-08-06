package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_72410 {

    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_'
                || c == '.') {
                answer.append(c);
            }
        }
        while (answer.toString().contains("..")) {
            answer = new StringBuilder(answer.toString().replace("..", "."));
        }
        if (answer.length() != 0 && answer.charAt(0) == '.') {
            answer = new StringBuilder(answer.substring(1));
        }
        if (answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }
        if (answer.toString().equals("")) {
            answer = new StringBuilder("a");
        }
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
            }
        }
        while (answer.length() <= 2) {
            answer.append(answer.charAt(answer.length() - 1));
        }
        return answer.toString();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String new_id, String expect) {
        Assertions.assertThat(solution(new_id)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of("...!@BaT#*..y.abcdefghijklm", "bat.y.abcdefghi"),
            Arguments.of("z-+.^.", "z--"),
            Arguments.of("=.=", "aaa"),
            Arguments.of("123_.def", "123_.def"),
            Arguments.of("abcdefghijklmn.p", "abcdefghijklmn")
        );
    }

}
