package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class pr3 {

    public int solutionTemp(int A, int B) {
        int ans = 0;
        String temp = Long.toBinaryString((long) A * B);

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                ans++;
            }
        }

        return ans;
    }

    public int solution(int A, int B) {
        String bA = Integer.toBinaryString(A);
        String bB = Integer.toBinaryString(B);
        return 0;
    }

    @Test
    void test() {
        Assertions.assertThat(solutionTemp(3, 7)).isEqualTo(3);
    }

    @Test
    void test2() {
        long a = (long)100000000 * 100000000;
        System.out.println(Long.toBinaryString(a));
    }
}
