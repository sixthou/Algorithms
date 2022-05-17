package codility;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountTriangles {

    public int solution(int[] A) {
        int ans = 0;
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                int k = j - 1;
                while ((k >= 0) && (A[i] < (A[j] + A[k]))) {
                    ans++;
                    k--;
                }
            }
        }
        return ans;
    }

    @Test
    void test1() {
        Assertions.assertThat(solution(new int[]{10, 2, 5, 1, 8, 12})).isEqualTo(4);
    }

    @Test
    void test2() {
        Assertions.assertThat(solution(new int[]{10, 7, 5})).isEqualTo(1);
    }

    @Test
    void test3() {
        Assertions.assertThat(solution(new int[]{10, 7})).isEqualTo(0);
    }

}
