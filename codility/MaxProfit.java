package codility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProfit {

    /*
      A[0] = 23171
      A[1] = 21011
      A[2] = 21123
      A[3] = 21366
      A[4] = 21013
      A[5] = 21367
    */
    public int solution(int[] A) {
        int ans = 0;
        if (A.length == 0) {
            return ans;
        }
        int min = A[0];

        for (int n : A) {
            if (n < min) {
                min = n;
            }
            int profit = n - min;
            if (profit > ans) {
                ans = profit;
            }
        }
        return ans;
    }

    @Test
    void test_1() {
        Assertions.assertThat(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367})).isEqualTo(356);
    }
}
