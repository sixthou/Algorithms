package codility;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingInteger {
    public int solution(int[] A){

        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        for (int i = 1; i < 100_001; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{1, 3, 6, 4, 1, 2}), 5);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(new int[]{-1, -3}), 1);
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(solution(new int[]{100000}), 1);
    }
}
