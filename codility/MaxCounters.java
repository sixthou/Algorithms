package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxCounters {

    public int[] solution(int N, int[] A) {

        int[] ans = new int[N];
        int max = 0;
        int temp = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                max = temp;
            } else {
                if (ans[A[i] - 1] < max) {
                    ans[A[i] - 1] = max + 1;
                } else {
                    ans[A[i] - 1]++;
                }

                if (ans[A[i] - 1] > temp) {
                    temp = ans[A[i] - 1];
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] < max) {
                ans[i] = max;
            }
        }

        return ans;
    }


    @Test
    public void test_1() {
        Assertions.assertArrayEquals(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4,}), new int[]{3, 2, 2, 4, 2});
    }

}
