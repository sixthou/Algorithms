package codility;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Fish {

    /*
      A[0] = 4    B[0] = 0
      A[1] = 3    B[1] = 1
      A[2] = 2    B[2] = 0
      A[3] = 1    B[3] = 0
      A[4] = 5    B[4] = 0
     */
    public int solution(int[] A, int[] B) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            int direction = B[i];

            if (direction == 0) {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    while (!stack.isEmpty()) {
                        if (A[i] > A[stack.peek()]) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    if (stack.isEmpty()) {
                        ans++;
                    }
                }
            } else {
                stack.push(i);
            }
        }

        return ans + stack.size();
    }

    @Test
    public void test_1() {
        Assertions.assertEquals(solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}), 2);
    }

}
