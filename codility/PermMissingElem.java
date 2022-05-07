package codility;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermMissingElem {

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i]) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{2, 3, 1, 5}), 4);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(new int[]{}), 1);
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(solution(new int[]{1}), 2);
    }

    @Test
    public void test_4() {
        Assertions.assertEquals(solution(new int[]{1, 2}), 3);
    }

}
