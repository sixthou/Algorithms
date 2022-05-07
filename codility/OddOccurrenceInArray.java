package codility;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OddOccurrenceInArray {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.remove(A[i]);
                continue;
            }
            map.put(A[i], i);
        }

        return (int) map.keySet().toArray()[0];
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{9, 3, 9, 3, 9, 7, 9}), 7);
    }
}

