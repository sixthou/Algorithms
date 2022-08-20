package programmers;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_118666 {

    private List<String> KEYS = Arrays.asList("R", "T", "C", "F", "J", "M", "A", "N");
    private int[] POINTS = new int[]{0, 3, 2, 1, 0, 1, 2, 3};

    public String solution(String[] survey, int[] choices) {
        List<String> KEYS = Arrays.asList("R", "T", "C", "F", "J", "M", "A", "N");
        int[] POINTS = new int[]{0, 3, 2, 1, 0, 1, 2, 3};
        StringBuilder answer = new StringBuilder();
        //점수
        Map<String, Integer> map = KEYS.stream()
            .collect(Collectors.toMap(Function.identity(), i -> 0));

        for (int i = 0; i < survey.length; i++) {
            String nowN = String.valueOf(survey[i].charAt(0));
            String nowP = String.valueOf(survey[i].charAt(1));
            int p = POINTS[choices[i]];

            if (choices[i] <= 3) {
                map.put(nowN, map.get(nowN) + POINTS[choices[i]]);
            } else {
                map.put(nowP, map.get(nowP) + POINTS[choices[i]]);
            }
        }
        int i = 0;
        while (i < KEYS.size()) {
            int a = map.get(KEYS.get(i));
            int b = map.get(KEYS.get(i + 1));
            if (a == b) {
                int compareTo = KEYS.get(i).compareTo(KEYS.get(i + 1));
                if (compareTo < 0) {
                    answer.append(KEYS.get(i));
                } else {
                    answer.append(KEYS.get(i + 1));
                }
            } else if (a > b) {
                answer.append(KEYS.get(i));
            } else {
                answer.append(KEYS.get(i + 1));
            }
            i = i + 2;
        }

        return answer.toString();
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] survey, int[] choices, String expect) {
        Assertions.assertThat(solution(survey, choices)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5},
                "TCMA"),
            Arguments.of(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}, "RCJA")
        );
    }

}

