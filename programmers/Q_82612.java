package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_82612 {

    public long solution(int price, int money, int count) {
        long temp = 0;
        for (int i = 1; i <= count; i++) {
            temp += (long) i * price;
        }

        return temp > money ? temp - money : 0;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int price, int money, int count, int expect) {
        Assertions.assertThat(solution(price, money, count)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(3, 20, 4, 10)
        );
    }

}
