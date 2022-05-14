package codility;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquiLeader {

    /*
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
     */
    public int solution(int[] A) {
        int n = A.length;
        int ans = 0;
        if (n == 1) {
            return 0;
        }
        int target = n / 2;
        int leader = 1_000_000_001;
        int cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();
        if (target == 0) {
            leader = A[0];
        } else {
            for (int i = 0; i < n; i++) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
                if (map.get(A[i]) > target) {
                    leader = A[i];
                    cnt = map.get(A[i]);
                }
            }
        }

        if (leader == 1_000_000_001) {
            return 0;
        }

        int left = 0;
        int right = cnt;

        for (int i = 0; i < n; i++) {
            int rt = ((n - (i + 1)) / 2) + 1;
            int lr = ((i + 1) / 2) + 1;
            if (A[i] == leader) {
                left++;
                right--;
            }
            if ((right >= rt) && (left >= lr)) {
                ans++;
            }
        }

        return ans;
    }


    @Test
    void test_1() {
        Assertions.assertThat(solution(new int[]{4, 3, 4, 4, 4, 2})).isEqualTo(2);
    }

    @Test
    void test_2() {
        Assertions.assertThat(solution(new int[]{4})).isEqualTo(0);
    }

    @Test
    void test_3() {
        Assertions.assertThat(solution(new int[]{4, 3, 4, 4})).isEqualTo(2);
    }

    @Test
    void test_4() {
        Assertions.assertThat(solution(new int[]{1, 2, 1, 1, 2, 1})).isEqualTo(3);
    }
}
