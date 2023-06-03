package softeer;

import java.util.Scanner;

public class LV1_3 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=362
     * 입력예제1
     * 5
     * 1 1
     * 2 3
     * 3 4
     * 9 8
     * 5 2
     * 출력예제1
     * Case #1: 2
     * Case #2: 5
     * Case #3: 7
     * Case #4: 17
     * Case #5: 7
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int targetCount = sc.nextInt();

        for(int i = 1 ; i <= targetCount ; i++){
            System.out.printf("Case #%d: %d\n",  i, sc.nextInt() + sc.nextInt());
        }

    }
}
