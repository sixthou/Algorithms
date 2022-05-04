package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryGap {

    public int solution(int N) {
        int num = N;
        StringBuffer sb = new StringBuffer();
        while (num > 1) {
            sb.append(num % 2);
            num = num / 2;
        }
        sb.append(num);
        String binaryNumber = sb.reverse().toString();

        int maxGap = 0;
        int tmpGap = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '1') {
                if (tmpGap > maxGap) {
                    maxGap = tmpGap;
                }
                tmpGap = 0;
                continue;
            }
            tmpGap++;
        }
        return maxGap;
    }

    @Test
    public void test_1(){
        Assertions.assertEquals(solution(1041), 5);
    }
    @Test
    public void test_2(){
        Assertions.assertEquals(solution(15), 0);
    }
    @Test
    public void test_3(){
        Assertions.assertEquals(solution(32), 0);
    }
}


