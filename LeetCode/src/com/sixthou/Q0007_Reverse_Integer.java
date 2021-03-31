package com.sixthou;

public class Q0007_Reverse_Integer {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }

    static class Solution {
        public int reverse(int x) {
            long ans = 0;

            while(x!=0){
                int tmp = x%10;
                x = x/10;
                ans = ans * 10 + tmp;
            }
            if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
                return 0;
            }else{
                return (int)ans;
            }
        }
    }
}
