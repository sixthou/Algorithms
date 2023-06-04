package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_160586 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 대충 만든 자판
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/160586
     * 난이도 : 1
     * 유형 : 단순구현
     * 설명 :
     * 예외 :
     **/

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alphabets = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                                    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                                    -1, -1, -1, -1, -1, -1};

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int now = key.charAt(i) - 'A';
                if (alphabets[now] == -1) {
                    alphabets[now] = i + 1;
                } else if (alphabets[now] > i + 1) {
                    alphabets[now] = i +1 ;
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int now = targets[i].charAt(j) - 'A';
                if (alphabets[now] == -1) {
                    tempSum = -1;
                    break;
                }
                tempSum += alphabets[now];
            }
            answer[i] = tempSum;
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] keymap, String[] targets, int[] expect) {
        Assertions.assertThat(solution(keymap, targets)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"}, new int[]{9, 4}),
                Arguments.of(new String[]{"AA"}, new String[]{"B"}, new int[]{-1}),
                Arguments.of(new String[]{"AGZ", "BSSS"}, new String[]{"ASA","BGZ"}, new int[]{4, 6})
        );
    }
}
