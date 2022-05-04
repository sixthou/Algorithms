package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q0013_Roman_To_Integer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
    }
    static class Solution {
        public int romanToInt(String s) {
            int ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);

            ans = map.get(s.charAt(s.length()-1));
            for(int i = 0; i<s.length()-1;i++){
                int now = map.get(s.charAt(i));
                if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                    ans += map.get(s.charAt(i));
                }else{
                    ans -= map.get(s.charAt(i));
                }
            }
            return ans;
        }
    }
}
