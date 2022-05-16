package codility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSliceSum {
    /*
    A[0] = 3  A[1] = 2  A[2] = -6
    A[3] = 4  A[4] = 0
     */
    /*
    카데인 알고리즘.
    최대부분합은 이전 최대 부분합이 반영된것.
     */

    public int solution(int[] A) {
        int ans = A[0];
        int tmp = A[0];
        for (int i = 1; i < A.length; i++) {
            tmp = Math.max(A[i], tmp + A[i]);
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    @Test
    void test1() {
        Assertions.assertThat(solution(new int[]{0})).isEqualTo(0);
    }

    @Test
    void test2() {
        Assertions.assertThat(solution(new int[]{3, 2, -6, 4, 0})).isEqualTo(5);
    }

    @Test
    void test3() {
        Assertions.assertThat(solution(new int[]{-1, 2})).isEqualTo(2);
    }

    @Test
    void test4() {
        Assertions.assertThat(solution(new int[]{-2, 1})).isEqualTo(1);
    }

    @Test
    void test5() {
        Assertions.assertThat(solution(new int[]{1, 2, 3, 4})).isEqualTo(10);
    }
    @Test
    void test6() {
        Assertions.assertThat(solution(new int[]{3, -2, 3})).isEqualTo(4);
    }

}
