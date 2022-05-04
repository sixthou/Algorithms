package leetcode;

public class Q0053_Maximum_Subarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, -2, -3, -4, -5};
        System.out.println(solution.maxSubArray(nums));

    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int max = nums[0];

            for(int i=1; i< nums.length ; i++){
                if(nums[i] > nums[i]+sum){
                    sum = nums[i];
                }else{
                    sum += nums[i];
                }

                if(sum > max) max = sum;
            }

            return max;
        }
    }
}
