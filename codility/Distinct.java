package codility;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Distinct {

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int i : A){
            set.add(i);
        }

        return set.size();
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{2, 1, 1, 2, 3, 1}), 3);
    }


}
