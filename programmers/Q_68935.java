package programmers;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_68935 {

    public int solution(int n) {
        int answer = 0;
        String temp = "";
        while (n > 0) {
            temp += n % 3;
            n = n / 3;
        }

        System.out.println(temp);
        String[] numbers = temp.split("");
        for (int i = 0; i < temp.length(); i++) {
            answer += Math.pow(3, temp.length() - 1 - i) * Integer.parseInt(numbers[i]);
        }
        return answer;
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int x, int expect) {
        Assertions.assertThat(solution(x)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(45, 7),
            Arguments.of(125, 229)
        );
    }

}
