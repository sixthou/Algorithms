package programmers;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_43162 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            q.add(i);
            while (!q.isEmpty()) {
                int now = q.poll();
                visited[now] = 1;
                for (int j = 0; j < n; j++) {
                    if (computers[now][j] == 1 && visited[j] == 0) {
                        q.add(j);
                    }
                }
            }
            answer++;
        }

        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n, int[][] computers, int expect) {
        assertThat(solution(n, computers)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
            Arguments.of(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, 1)
        );
    }

}
