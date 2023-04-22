package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_68645 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : 삼각 달팽이
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/68645
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 단순구현
     * 예외 :
     **/

    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] map = new int[n + 1][n + 1];
        int target = (n * (n + 1)) / 2;
        int index = 1;
        int ni = 1;
        int nj = 1;
        int flag = 1; // 1 down 2 right 3 diagonal
        map[ni][nj] = 1;

        while (index < target) {
            switch (flag) {
                case 1:
                    if (ni +1 <= n && map[ni + 1][nj] == 0) {
                        ni++;
                    } else {
                        flag = 2;
                        continue;
                    }
                    break;
                case 2:
                    if (nj + 1 <= n && map[ni][nj + 1] == 0) {
                        nj++;
                    } else {
                        flag = 3;
                        continue;
                    }
                    break;
                case 3:
                    if (map[ni - 1][nj - 1] == 0) {
                        ni--;
                        nj--;
                    } else {
                        flag = 1;
                        continue;
                    }
                    break;
            }
            index++;
            map[ni][nj] = index;
        }

        int arrayIndex = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] == 0) {
                    break;
                }
                answer[arrayIndex] = map[i][j];
                arrayIndex++;
            }
        }

        return answer;
    }




    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int n , int[] expect) {
        Assertions.assertThat(solution(n)).isEqualTo(expect);
    }





    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(1, new int[]{1}),
                Arguments.of(2, new int[]{1, 2, 3}),
                Arguments.of(3, new int[]{1, 2, 6, 3, 4, 5}),
                Arguments.of(4, new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7}),
                Arguments.of(5, new int[]{1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9}),
                Arguments.of(6, new int[]{1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11})
        );
    }
}
