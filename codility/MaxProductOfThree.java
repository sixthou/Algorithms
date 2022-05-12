package codility;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);
        int idx = A.length - 1;
        int max1 = A[idx] * A[idx - 1] * A[idx - 2];
        int max2 = A[0] * A[1] * A[idx];
        return max1 > max2 ? max1 : max2;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{-3, 1, 2, -2, 5, 6}), 60);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(new int[]{-3, 1, -2, -2, 5, 6}), 36);
    }

}
