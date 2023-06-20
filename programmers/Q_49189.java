package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_49189 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 가장 먼 노드
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/49189
     * 난이도 : LV3
     * 유형 : bfs
     * 설명 : 단순 bfs
     * 예외 :
     **/

    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        int[] visited = new int[n + 1];

        for (int[] now : edge) {
            map[now[0]][now[1]] = true;
            map[now[1]][now[0]] = true;
        }

        Queue<Integer> que = new LinkedList<>();
        visited[1] = 1;
        que.add(1);
        int maxVal = 0;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 1; i <= n; i++) {
                if (map[now][i] && visited[i] == 0) {
                    que.add(i);
                    visited[i] = visited[now] + 1;
                    if (visited[i] > maxVal) {
                        maxVal = visited[i];
                    }
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == maxVal) {
                answer++;
            }
        }

        return answer;
    }



    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int[][] edge, int expect) {
        Assertions.assertThat(solution(n, edge)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}},	3)
        );
    }

}
