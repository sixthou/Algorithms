package softeer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LV2_2 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=408
     * 입력예제1
     * 1 2 3 4 5 6 7 8
     * 출력예제1
     * ascending
     */

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(solustion(nums));


    }

    private static String solustion(List<Integer> nums){
        int target = nums.get(0) - nums.get(1);

        for(int i = 1 ; i < nums.size()-1 ; i ++){
            if(nums.get(i) - nums.get(i+1) != target){
                return "mixed";
            }
        }

        if(target > 0){
            return "descending";
        }

        return "ascending";
    }
}
