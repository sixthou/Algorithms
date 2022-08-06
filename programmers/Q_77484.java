package programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_77484 {

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> answer = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());

        int hit = 0;
        int zero = 0;

        for (int i : lottos) {
            if (answer.contains(i)) {
                hit++;
            }
            if (i == 0) {
                zero++;
            }
        }

        return new int[]{getRank(hit + zero), getRank(hit)};

    }

    private int getRank(int hit) {
        if (hit <= 1) {
            return 6;
        }
        return 7 - hit;

    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] lottos, int[] win_nums, int[] expect) {
        Assertions.assertThat(solution(lottos, win_nums)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19},
                new int[]{3, 5}),
            Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25},
                new int[]{1, 6}),
            Arguments.of(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35},
                new int[]{1, 1})
        );
    }

}
