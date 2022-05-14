package codility;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dominator {

    /*
     A[0] = 3    A[1] = 4    A[2] =  3
     A[3] = 2    A[4] = 3    A[5] = -1
     A[6] = 3    A[7] = 3
     */
    public int solution(int[] A) {

        int n = A.length;
        int target = n / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) > target) {
                return i;
            }
        }

        return -1;
    }

    @Test
    void test_1() {
        Assertions.assertThat(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3})).isIn(0, 2, 4, 6, 7);
    }

    @Test
    void test_2() {
        Assertions.assertThat(solution(new int[]{2, 1, 1, 3})).isEqualTo(-1);
    }

    @Test
    void test_3() {
        Assertions.assertThat(solution(new int[]{1, 2, 1})).isIn(0,2);
    }
}
