package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_12950 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr1[0].length;
        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution_2(int[][] arr1, int[][] arr2, int[][] expect) {
        Assertions.assertThat(solution(arr1, arr2)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[][]{{1,2},{2,3}}	,new int[][]{{3,4},{5,6}}	, new int[][]{{4,6},{7,9}}),
            Arguments.of(new int[][]{{1},{2}}	,new int[][]{{3},{4}}	, new int[][]{{4},{6}})
        );
    }

}
