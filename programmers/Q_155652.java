package programmers;

import java.util.*;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_155652 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 둘만의 암호
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/155652
     * 난이도 : 1
     * 유형 : 단순구현
     * 설명 :
     * 예외 :
     **/

    public String solution(String s, String skip, int index) {
        List<Character> alphabets = new ArrayList<>();
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            char now = (char) (i + 'a');
            if (skip.contains(String.valueOf(now))) {
                continue;
            }
            alphabets.add(now);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nowIndex = (alphabets.indexOf(s.charAt(i)) + index) % alphabets.size();
            sb.append(alphabets.get(nowIndex));
        }

        return sb.toString();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, String skip, int index, String expect) {
        Assertions.assertThat(solution(s, skip, index)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("aukks", "wbqd", 5, "happy")
        );
    }
}
