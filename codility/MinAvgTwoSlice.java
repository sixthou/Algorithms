package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinAvgTwoSlice {

    public int solution(int[] A) {
        double avg = (A[0] + A[1]) / 2.0;
        int idx = 0;
        double tmp = 0.0;

        for (int i = 1; i < A.length; i++) {
            if (i >= 2) {
                tmp = (A[i - 2] + A[i - 1] + A[i]) / 3.0;
                if (tmp < avg) {
                    avg = tmp;
                    idx = i - 2;
                }
            }
            tmp = (A[i - 1] + A[i]) / 2.0;
            if (tmp < avg) {
                avg = tmp;
                idx = i - 1;
            }
        }

        return idx;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{5, 6, 3, 4, 9}), 2);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(new int[]{4, 2, 2, 5, 1, 5, 8}), 1);
    }


}
