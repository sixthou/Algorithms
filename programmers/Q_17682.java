package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17682 {

    public int solution(String dartResult) {
        List<String> collect = Arrays.stream(dartResult.split("")).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            if (i + 1 < collect.size() && collect.get(i).equals("1") && collect.get(i + 1)
                .equals("0")) {
                collect.set(i, "10");
                collect.remove(i + 1);
            }
        }
        String[] tokens = collect.toArray(String[]::new);
        int[] shots = new int[3];
        int shot = 0;

        for (int i = 0; i < tokens.length; ) {
            int point = Integer.parseInt(tokens[i]);
            String bouns = tokens[i + 1];
            switch (bouns) {
                case "S":
                    break;
                case "D":
                    point = (int) Math.pow(point, 2);
                    break;
                case "T":
                    point = (int) Math.pow(point, 3);
                    break;
            }

            boolean hasOption = false;
            if (i + 2 < tokens.length) {
                if ("*".equals(tokens[i + 2])) {
                    if (shot != 0) {
                        shots[shot - 1] *= 2;
                    }
                    point *= 2;
                    hasOption = true;
                }

                if ("#".equals(tokens[i + 2])) {
                    point *= -1;
                    hasOption = true;
                }
            }
            if (hasOption) {
                i += 3;
            } else {
                i += 2;
            }
            shots[shot] = point;
            shot++;
        }

        return Arrays.stream(shots).sum();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String s, int expect) {
        Assertions.assertThat(solution(s)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of("1S2D*3T", 37),
            Arguments.of("1D2S#10S", 9),
            Arguments.of("1D2S0T", 3),
            Arguments.of("1S*2T*3S", 23),
            Arguments.of("1D#2S*3S", 5),
            Arguments.of("1T2D3D#", -4),
            Arguments.of("1D2S3T*", 59)
        );
    }

}
