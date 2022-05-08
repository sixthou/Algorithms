package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int left = 0;
        int right = 0;
        List<Integer> sum = new ArrayList<>();

        for (int i :A) {
            right += i;
        }

        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            sum.add(Math.abs(left - right));
        }

        return Collections.min(sum);
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{3, 1, 2, 4, 3}), 1);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(new int[]{-1000, 1000}), 2000);
    }
}
