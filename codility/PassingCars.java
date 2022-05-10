package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassingCars {

    public int solution(int[] A) {
        int ans = 0;
        int car = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                car++;
            } else {
                ans += car;
            }
        }

        return ans > 1_000_000_000 || ans < 0 ? -1 : ans;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{0, 1, 0, 1, 1}), 5);
    }

}
