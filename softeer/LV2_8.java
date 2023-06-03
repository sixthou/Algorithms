package softeer;

import java.util.Scanner;

public class LV2_8 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=584
     * 입력예제1
     * 3 3
     * 50 50
     * 40 40
     * 10 30
     * 60 76
     * 18 28
     * 22 50
     * 출력예제1
     * 36
     * 입력예제2
     * 3 3
     * 50 90
     * 10 90
     * 40 50
     * 50 40
     * 10 100
     * 40 40
     * 출력예제2
     * 10
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] param = sc.nextLine().split(" ");
        int N = Integer.parseInt(param[0]);
        int M = Integer.parseInt(param[1]);
        int[] standard = new int[101];

        int start = 0;
        for(int i =0 ; i < N ; i++){
            String[] input = sc.nextLine().split(" ");
            int length = Integer.parseInt(input[0]);
            int speed = Integer.parseInt(input[1]);
            for(int j = start+1 ; j <= start + length ; j++){
                standard[j] = speed;
            }
            start = start + length;
        }

        start = 0;
        int maxGap = 0;

        for(int i =0 ; i < M ; i++){
            String[] input = sc.nextLine().split(" ");
            int length = Integer.parseInt(input[0]);
            int speed = Integer.parseInt(input[1]);
            for(int j =start+1 ; j <= start + length ; j++){
                if(speed - standard[j] > maxGap){
                    maxGap = speed - standard[j];
                }
            }
            start = start + length;
        }

        System.out.println(maxGap);
    }


}
