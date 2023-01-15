package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FrogJmp2 {

    public int solution(int X, int Y, int D) {
        int gap = Y - X;
        int ans = gap / D;
        if ((gap % D) != 0) {
            ans++;
        }
        return ans;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int X, int Y, int D, int expect) {
        Assertions.assertThat(solution(X, Y, D)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(10, 85, 30, 3)
                );
    }
}

