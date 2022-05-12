package codility;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Triangle {

    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = 2; i < A.length; i++) {
            if ((long)A[i] < (long)A[i - 2] + (long)A[i - 1])
                return 1;
        }

        return 0;
    }

    @Test
    public void Test() {
        Assertions.assertEquals(solution(new int[]{10, 2, 5, 1, 8, 20}), 1);
    }
}
