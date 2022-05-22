package codility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountDistinctSlices {

    public int solution(int M, int[] A) {
        boolean chk[] = new boolean[M + 1];
        int ans = 0, right = 0;
        int n = A.length;

        for (int left = 0; left < n; left++) {
            while (right < A.length && !chk[A[right]]) {
                ans += (right - left + 1);
                chk[A[right]] = true;
                right++;
                if (ans >= 1000000000) {
                    return 1000000000;
                }
            }

            chk[A[left]] = false;

            if (ans >= 1000000000) {
                return 1000000000;
            }
        }

        return ans;
    }

    @Test
    void test_1() {
        Assertions.assertThat(solution(6, new int[]{3, 4, 5, 5, 2})).isEqualTo(9);
    }

    @Test
    void test_2() {
        Assertions.assertThat(solution(1, new int[]{1})).isEqualTo(1);
    }

    @Test
    void test_3() {
        Assertions.assertThat(solution(3, new int[]{1, 2, })).isEqualTo(6);
    }
}
