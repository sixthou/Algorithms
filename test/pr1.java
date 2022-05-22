package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class pr1 {

    public String solution(String S, int K) {
        String[] weekday = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int startIdx = 0;
        for (int i = 0; i < weekday.length; i++) {
            if (S.equals(weekday[i])) {
                startIdx = i;
            }
        }
        return weekday[(startIdx + K) % 7];
    }

    @Test
    void test1() {
        Assertions.assertThat(solution("Wed", 2)).isEqualTo("Fri");
    }

    @Test
    void test2() {
        Assertions.assertThat(solution("Sat", 23)).isEqualTo("Mon");
    }
    @Test
    void test3() {
        Assertions.assertThat(solution("Mon", 1)).isEqualTo("Tue");
    }

    @Test
    void test4() {
        Assertions.assertThat(solution("Mon", 0)).isEqualTo("Mon");
    }
}
