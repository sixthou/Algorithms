package codility;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class stoneWall {

    /*
        H[0] = 8    H[1] = 8    H[2] = 5
        H[3] = 7    H[4] = 9    H[5] = 8
        H[6] = 7    H[7] = 4    H[8] = 8
    */
    public int solution(int[] H) {
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        while (idx < H.length) {
            if (s.isEmpty()) {
                s.push(H[idx]);
                idx++;
            } else if (s.peek() == H[idx]) {
                idx++;
            } else if (s.peek() > H[idx]) {
                s.pop();
                ans++;
            } else if (s.peek() < H[idx]) {
                s.push(H[idx]);
                idx++;
            }
        }
        return ans + s.size();
    }



    @Test
    void test_1() {
        Assertions.assertEquals(solution(new int[]{9, 9, 5, 7, 9, 8, 7, 4, 8}), 7);
    }
}

