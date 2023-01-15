package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Distinct2 {

    public int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : A) {
            set.add(num);
        }

        return set.size();
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int expect) {
        Assertions.assertThat(solution(A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(),
                Arguments.of(),
                Arguments.of()
        );
    }
}
