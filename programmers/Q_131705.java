package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_131705 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 삼총사
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/131705
     * 난이도 : 1
     * 유형 : 구현
     * 설명 :
     * 예외 :
     **/

    static int answer;

    public int solution(int[] number) {
        answer = 0;
        dfs(0, new boolean[number.length], 0, 0, number);
        return answer;
    }

    private void dfs(int index, boolean[] visited, int sum, int count, int[] number) {
        if (count == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        if (index == visited.length) {
            return;
        }

        visited[index] = true;
        dfs(index + 1, visited, sum + number[index], count + 1, number);

        visited[index] = false;
        dfs(index + 1, visited, sum, count, number);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] number, int expect) {
        Assertions.assertThat(solution(number)).isEqualTo(expect);
    }



    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{-2, 3, 0, 2, -5}, 	2),
                Arguments.of(new int[]{-3, -2, -1, 0, 1, 2, 3}, 	5),
                Arguments.of(new int[]{-1, 1, -1, 1}, 	0)
        );
    }
}
