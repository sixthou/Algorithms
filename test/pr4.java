package test;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class pr4 {

    static int max = 0;
    static boolean checked = false;

    public int solution(int[] A, int K) {
        if (K > A.length) {
            return -1;
        }

        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        combination(A, visited, A.length - 1, A.length, K);

        return checked ? max : -1;
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (checked) {
            return;
        }

        if (r == 0) {
            cal(arr, visited, n);
            return;
        }

        for (int i = start; i >= 0; i--) {
            visited[i] = true;
            combination(arr, visited, i - 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void cal(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        if (sum > max && sum % 2 == 0) {
            max = sum;
            checked = true;
        }
    }


    @Test
    void test1() {
        Assertions.assertThat(solution(new int[]{4, 9, 8, 2, 6}, 3)).isEqualTo(18);
    }

    @Test
    void test2() {
        Assertions.assertThat(solution(new int[]{5, 6, 3, 4, 2}, 5)).isEqualTo(20);
    }

    @Test
    void test3() {
        Assertions.assertThat(solution(new int[]{7, 7, 7, 7, 7}, 1)).isEqualTo(-1);
    }

    @Test
    void test4() {
        Assertions.assertThat(solution(new int[]{10000}, 2)).isEqualTo(-1);
    }

    @Test
    void test5() {
        Assertions.assertThat(solution(new int[]{2, 3, 3, 5, 5}, 3)).isEqualTo(12);
    }
}
