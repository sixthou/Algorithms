package softeer;

import java.util.Scanner;

public class LV2_4 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=413
     * 입력예제1
     * 1
     * 출력예제1
     * 9
     */

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        System.out.println(solution(n));
    }

    private static int solution(int target){
        int points = 2;

        for(int i =0; i < target ; i++){
            points = points + points -1;
        }

        return points * points;
    }
}
