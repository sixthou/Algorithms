package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            ans[(i + K) % A.length] = A[i];
        }

        return ans;
    }

    @Test
    public void Test_1() {
        Assertions.assertArrayEquals(solution(new int[]{1, 2}, 0 ), new int[]{1, 2});
    }

    @Test
    public void Test_2() {
        Assertions.assertArrayEquals(solution(new int[]{1, 2}, 1 ), new int[]{2, 1});
    }

    @Test
    public void Test_3() {
        Assertions.assertArrayEquals(solution(new int[]{1, 2}, 2 ), new int[]{1, 2});
    }

    @Test
    public void Test_4() {
        Assertions.assertArrayEquals(solution(new int[]{1, 2}, 3 ), new int[]{2, 1});
    }
}


