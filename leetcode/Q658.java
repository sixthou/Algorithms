package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 이진탐색
 */

public class Q658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int closer = Integer.MAX_VALUE;
        int closeIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ACloserThenB(arr[i], closer, x)) {
                closer = arr[i];
                closeIndex = i;
            }
        }

        int leftIdx = closeIndex - 1;
        int rightIdx = closeIndex + 1;
        result.add(arr[closeIndex]);
        k--;

        while (k > 0) {
            if (leftIdx >= 0 && rightIdx < arr.length && ACloserThenB(arr[leftIdx], arr[rightIdx], x)) {
                result.add(arr[leftIdx]);
                leftIdx--;
            } else if (leftIdx >= 0 && rightIdx < arr.length && !ACloserThenB(arr[leftIdx], arr[rightIdx], x)) {
                result.add(arr[rightIdx]);
                rightIdx++;
            } else if (leftIdx >= 0) {
                result.add(arr[leftIdx]);
                leftIdx--;
            } else {
                result.add(arr[rightIdx]);
                rightIdx++;
            }
            k--;
        }

        Collections.sort(result);
        return result;
    }

    private boolean ACloserThenB(int a, int b, int target) {
        if (Math.abs(a - target) < Math.abs(b - target)) {
            return true;
        } else if ((Math.abs(a - target) == Math.abs(b - target) && a < b)) {
            return true;
        }
        return false;
    }

    public List<Integer> findClosestElements_solution(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements_solution_2(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (right + left) / 2;
            if (x - A[mid] > A[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            result.add(A[i]);
        }

        return result;
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test(int[] arr, int k, int x, List<Integer> expect) {
        Assertions.assertThat(findClosestElements(arr, k, x)).isEqualTo(expect);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int[] arr, int k, int x, List<Integer> expect) {
        Assertions.assertThat(findClosestElements_solution(arr, k, x)).isEqualTo(expect);
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution_2(int[] arr, int k, int x, List<Integer> expect) {
        Assertions.assertThat(findClosestElements_solution_2(arr, k, x)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4, Arrays.asList(0, 1, 1, 1, 2, 3, 6, 7, 8)),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, 3, Arrays.asList(1, 2, 3, 4)),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, -1, Arrays.asList(1, 2, 3, 4))
        );
    }


}
