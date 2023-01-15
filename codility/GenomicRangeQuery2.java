package codility;

import java.util.HashMap;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GenomicRangeQuery2 {


    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] ans = new int[M];
        HashMap<Character, Integer> DNA = new HashMap<>();
        DNA.put('A', 1);
        DNA.put('C', 2);
        DNA.put('G', 3);
        DNA.put('T', 4);

        int[][] map = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            map[i] = map[i - 1].clone();
            map[i][DNA.get(S.charAt(i - 1)) - 1]++;
        }

        for (int i = 0; i < M; i++) {
            int[] behind = map[Q[i] + 1];
            int[] front = map[P[i]];
            for (int j = 0; j < 4; j++) {
                if (behind[j] - front[j] > 0) {
                    ans[i] = j + 1;
                    break;
                }
            }
        }

        return ans;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String S, int[] P, int[] Q, int[] expect) {
        Assertions.assertThat(solution(S, P, Q)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
                Arguments.of("AAAAAAA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{1, 1, 1})
        );
    }
}
