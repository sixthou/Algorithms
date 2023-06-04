package programmers;

import java.util.Stack;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_133502 {
    /**
     * 제공자 : 프로그래머스
     * 제목 : 햄버거 만들기
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/133502
     * 난이도 : 1
     * 유형 : 스택
     * 설명 :
     * 예외 :
     **/


    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            if (stack.size() < 3) {
                stack.add(ingredient[i]);
            } else {
                int now = ingredient[i];
                int meat = stack.pop();
                int vege = stack.pop();
                int bread = stack.pop();
                if (bread == 1 && vege == 2 && meat == 3 && now == 1) {
                    answer++;
                } else {
                    stack.push(bread);
                    stack.push(vege);
                    stack.push(meat);
                    stack.push(now);
                }
            }
        }

        return answer;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] ingredient, int expect) {
        Assertions.assertThat(solution(ingredient)).isEqualTo(expect);
    }


    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1},	5),
                Arguments.of(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1},	2),
                Arguments.of(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2},	0)
        );

    }
}
