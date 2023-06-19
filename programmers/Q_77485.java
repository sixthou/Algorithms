package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_77485 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 행렬 테두리 회전하기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/77485
     * 난이도 : 2
     * 유형 : 단순구현
     * 설명 :
     * 예외 :
     **/

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int index = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = index++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotateAndGetMinimum(map, queries[i]);
        }

        return answer;
    }

    private int rotateAndGetMinimum(int[][] map, int[] query) {
        int min = Integer.MAX_VALUE;
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int now = map[x1][y1];
        int next = map[x1][y1];

        //위
        for (int i = y1 + 1; i <= y2; i++) {
            next = map[x1][i];
            map[x1][i] = now;
            now = next;
            if (now < min) {
                min = now;
            }
        }
        //오
        for (int i = x1 + 1; i <= x2; i++) {
            next = map[i][y2];
            map[i][y2] = now;
            now = next;
            if (now < min) {
                min = now;
            }
        }
        //아
        for (int i = y2 - 1; i >= y1; i--) {
            next = map[x2][i];
            map[x2][i] = now;
            now = next;
            if (now < min) {
                min = now;
            }
        }
        //왼
        for (int i = x2 - 1; i >= x1; i--) {
            next = map[i][y1];
            map[i][y1] = now;
            now = next;
            if (now < min) {
                min = now;
            }
        }

        return min;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int rows, int columns, int[][] queries, int[] expect) {
        Assertions.assertThat(solution(rows, columns, queries)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}},
                        new int[]{1, 1, 5, 3}),
                Arguments.of(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}, new int[]{8, 10, 25}),
                Arguments.of(100, 97, new int[][]{{1, 1, 100, 97}}, new int[]{1})
        );
    }

}
