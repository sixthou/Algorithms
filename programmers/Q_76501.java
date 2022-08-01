package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_76501 {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] absolutes, boolean[] signs, int expect) {
        Assertions.assertThat(solution(absolutes, signs)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{4, 7, 12}, new boolean[]{true, false, true}, 9),
            Arguments.of(new int[]{1, 2, 3}, new boolean[]{false, false, true}, 0)
        );
    }
}

