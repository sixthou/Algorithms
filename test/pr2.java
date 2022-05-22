package test;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class pr2 {

    public int solution(String S) {
        int ans = 0;
        int max = 0;
        ArrayList<Integer> stringList = new ArrayList<>();
        String temp = "";

        for (int i = 0; i < S.length(); i++) {
            char now = S.charAt(i);
            if (temp.length() == 0) {
                temp += now;
            } else {
                if (now != temp.charAt(temp.length() - 1)) {
                    stringList.add(temp.length());
                    if (temp.length() > max) {
                        max = temp.length();
                    }
                    temp = "" + now;

                } else {
                    temp += now;
                }
            }
        }

        stringList.add(temp.length());
        if (temp.length() > max) {
            max = temp.length();
        }

        for (int i = 0; i < stringList.size(); i++) {
            ans += (max - stringList.get(i));
        }

        return ans;
    }

    @Test
    void test1() {
        Assertions.assertThat(solution("babaa")).isEqualTo(3);
    }

    @Test
    void test2() {
        Assertions.assertThat(solution("bbbab")).isEqualTo(4);
    }

    @Test
    void test3() {
        Assertions.assertThat(solution("bbbaaabbb")).isEqualTo(0);
    }

    @Test
    void test4() {
        Assertions.assertThat(solution("a")).isEqualTo(0);
    }
}
