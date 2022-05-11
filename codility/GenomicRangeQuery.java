package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int[] ans = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            String s = S.substring(P[i], Q[i] + 1);

            ans[i] = findMin(s);
        }

        return ans;
    }

    private int findMin(String subString) {
        if (subString.contains("A")) {
            return 1;
        } else if (subString.contains("C")) {
            return 2;
        } else if (subString.contains("G")) {
            return 3;
        } else {
            return 4;
        }
    }

    @Test
    public void test_1() {
        Assertions.assertArrayEquals(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}), new int[]{2, 4, 1});
    }

    @Test
    public void test_2() {
        Assertions.assertArrayEquals(solution("A", new int[]{0}, new int[]{0}), new int[]{1});
    }
}
