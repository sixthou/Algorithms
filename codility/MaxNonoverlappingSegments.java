package codility;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNonoverlappingSegments {


    public int solution(int[] A, int[] B) {
        if (A.length < 1) {
            return 0;
        }

        int ans = 1, end = B[0];


        for (int i = 1; i < A.length; i++) {
            if (A[i] > end) {
                end = B[i];
                ans++;
            }
        }
        return ans;
    }

    /*
    A[0] = 1    B[0] = 5
    A[1] = 3    B[1] = 6
    A[2] = 7    B[2] = 8
    A[3] = 9    B[3] = 9
    A[4] = 9    B[4] = 10
     */
    @Test
    void test1() {
        Assertions.assertThat(solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10})).isEqualTo(3);
    }

}
