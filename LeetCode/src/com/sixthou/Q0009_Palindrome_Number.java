package com.sixthou;

public class Q0009_Palindrome_Number {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome(-11));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(12321));

    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0 || (x%10 == 0 && x != 0)) return false;

            int rx =0;
            while(x>rx){
                rx = rx * 10 + x % 10;
                x = x/10;
            }

            return x == rx || x == rx/10;
        }
    }
}
