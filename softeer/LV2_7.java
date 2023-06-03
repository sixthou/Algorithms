package softeer;

import java.util.Scanner;

public class LV2_7 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=624
     * 입력예제1
     * 2
     * 1 2
     * 9881 10724
     * 출력예제1
     * 5
     * 11
     * 입력예제2
     * 2
     * 111 11
     * 11 11111
     * 출력예제2
     * 2
     * 6
     */

    static int[][] numbers = new int[][]{
            //            0. 1. 2. 3. 4. 5. 6
            new int[]{1, 1, 1, 0, 1, 1, 1}, //0
            new int[]{0, 0, 1, 0, 0, 1, 0}, //1
            new int[]{1, 0, 1, 1, 1, 0, 1}, //2
            new int[]{1, 0, 1, 1, 0, 1, 1}, //3
            new int[]{0, 1, 1, 1, 0, 1, 0}, //4
            new int[]{1, 1, 0, 1, 0, 1, 1}, //5
            new int[]{1, 1, 0, 1, 1, 1, 1}, //6
            new int[]{1, 1, 1, 0, 0, 1, 0}, //7
            new int[]{1, 1, 1, 1, 1, 1, 1}, //8
            new int[]{1, 1, 1, 1, 0, 1, 1}, //9
            new int[]{0, 0, 0, 0, 0, 0, 0} //off
    };


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < num ; i++){
            String[] target = sc.nextLine().split(" ");
            System.out.println(solution(target[0], target[1]));
        }


    }

    public static int solution(String asIs, String toBe){
        String[] asIsTokens = asIs.split("");
        String[] toBeTokens = toBe.split("");
        int[] a = new int[]{10, 10, 10, 10, 10};
        int[] b = new int[]{10, 10, 10, 10, 10};

        int sum =0;

        for(int i = asIsTokens.length - 1 ; i >= 0 ; i--){
            a[5 - asIsTokens.length + i ] = Integer.parseInt(asIsTokens[i]);
        }
        for(int i = toBeTokens.length - 1 ; i >= 0 ; i--){
            b[5 - toBeTokens.length + i] = Integer.parseInt(toBeTokens[i]);
        }

        for(int i = 0; i < 5; i++){
            sum += findDiff(a[i], b[i]);
        }

        return sum;
    }

    static private int findDiff(int a, int b){
        int count =0;
        if(a == b){
            return count;
        }

        for(int i = 0 ; i < 7 ; i++){
            if(numbers[a][i] != numbers[b][i]){
                count++;
            }
        }
        return count;
    }

}
