package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class countDiv {

    public int solution(int A, int B, int K) {
        int first = A / K;
        int last = B / K;

        if (A % K != 0) {
            first = first + 1;
        }

        return last - first + 1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(6, 11, 2), 3);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(1, 1, 1), 1);
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(solution(1, 1, 2), 0);
    }

}
