package softeer;

import java.util.Scanner;

public class LV2_9 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=407
     * 입력예제1
     * 2 3 2
     * 출력예제1
     * 18
     */

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String[] param = sc.nextLine().split(" ");
        int K = Integer.parseInt(param[0]);
        int P = Integer.parseInt(param[1]);
        int N = Integer.parseInt(param[2]);

        long sum = (long) K;
        for(int i =0; i < N ; i++){
            sum = (sum * P) %1000000007;
        }

        System.out.println(sum);
    }
}
