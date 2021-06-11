package com.sixthou;

import java.util.HashMap;
import java.util.Map;

public class Q1880_Check_if_Word_Equals_Summation_of_Two_Words {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSumEqual("acb",  "cba", "cdb"));
    }

    static class Solution{
        static Map<Character, Integer> map = new HashMap<>();

        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            int start = 'a' - 97, end = 'j' - 97;

            for(int i = start ; i <= end ; i++) {
                map.put((char) (i + 97), i);
            }

            if(workToNum(firstWord) + workToNum(secondWord) == workToNum(targetWord)){
                return true;
            }else{
                return false;
            }
        }

        static public int workToNum(String word){
            int num = 0;
            for(int i = 0; i < word.length() ; i++){
                num = num *10 + map.get(word.charAt(i));
            }
            return num;
        }
    }
}


