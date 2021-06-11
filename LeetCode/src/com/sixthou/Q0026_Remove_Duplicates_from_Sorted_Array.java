package com.sixthou;

import java.util.*;

public class Q0026_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        solution.removeDuplicates(nums);
    }
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int target = 0;

            for(int i = 0 ; i< nums.length; i++){
                if(nums[target]!=nums[i]){
                    nums[target+1] = nums[i];
                    target++;
                }
            }

            return target + 1;

        }
    }
}













