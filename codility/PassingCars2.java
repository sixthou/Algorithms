package codility;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PassingCars2 {

    public int solution(int[] A) {
        int eastCar = 0;
        long passingCars = 0;

        for (int direction : A) {
            if (direction == 0) {
                eastCar++;
            }
            if (direction == 1) {
                passingCars = passingCars + eastCar;
            }
            if (passingCars > 1000000000) {
                return -1;
            }
        }

        return (int) passingCars;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] A, int expect) {
        Assertions.assertThat(solution(A)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{0,1,0,1,1}, 5)
        );
    }
}
