package codility;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FrogRiverOne2 {

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            set.add(i);
        }
        for (int i = 0; i < A.length; i++) {

            if (set.contains(A[i])) {
                set.remove(A[i]);
            }

            if (set.isEmpty()) {
                return i;
            }
        }

        return -1;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int X, int[] A, int expect) {
        Assertions.assertThat(solution(X, A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6)
        );
    }
}
