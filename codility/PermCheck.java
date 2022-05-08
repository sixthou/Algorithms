package codility;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermCheck {

    public int solution(int[] A) {

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{4, 1, 3, 2}), 1);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(new int[]{4, 1, 3}), 0);
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(solution(new int[]{4}), 0);
    }

    @Test
    public void test_4() {
        Assertions.assertEquals(solution(new int[]{9, 5, 7, 3, 2, 7, 3, 1, 10, 8}), 0);
    }

    @Test
    public void test_5() {
        Assertions.assertEquals(solution(new int[]{1, 1}), 0);
    }


}
