package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q0001_Two_sum {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< nums.length ; i++){
                map.put(nums[i], i);
            }
            int[] ans = new int[2];
            for(int i = 0; i<nums.length ; i++){
                int com = target - nums[i];
                if(map.containsKey(com) && map.get(com) != i){
                    ans[0] = i;
                    ans[1] = map.get(com);
                }
            }
            return ans;
        }
    }
}
