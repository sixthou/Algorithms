package codility;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}), 6);
    }

}
