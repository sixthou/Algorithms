package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_86971 {
    /**
     * 제공자 :
     * 제목 : 전력망을 둘로 나누기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/86971
     * 난이도 :
     * 유형 :
     * 설명 :
     * 예외 :
     **/

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[][] map = new boolean[n+1][n+1];


        for (int[] now : wires) {
            map[now[0]][now[1]] = true;
            map[now[1]][now[0]] = true;
        }

        for (int[] wire : wires) {
            int now = func(map, wire, n);
            if (answer > now) {
                answer = now;
            }
        }

        return answer;
    }

    private int func(boolean[][] map, int[] wire, int n) {
        int count = 1;
        boolean[] visited = new boolean[n + 1];
        map[wire[0]][wire[1]] = false;
        map[wire[1]][wire[0]] = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (map[now][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        map[wire[0]][wire[1]] = true;
        map[wire[1]][wire[0]] = true;
        return Math.abs(count - Math.abs((n-count)));
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int[][] wires, int expect) {
        Assertions.assertThat(solution(n, wires)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}	,3),
                Arguments.of(4, new int[][]{{1,2},{2,3},{3,4}}	,0),
                Arguments.of(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}	, 1)
        );
    }

}
