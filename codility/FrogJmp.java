package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrogJmp {

    public int solution(int X, int Y, int D) {

        return (Y - X) % D == 0 ? (Y - X) / D : (Y - X) / D + 1;
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(10, 85, 30), 3);
    }

    @Test
    public void test_2() {
        Assertions.assertEquals(solution(10, 10, 30), 0);
    }

    @Test
    public void test_3() {
        Assertions.assertEquals(solution(10, 11, 30), 1);
    }

    @Test
    public void test_4() {
        Assertions.assertEquals(solution(1, 5, 2), 2);
    }
}
