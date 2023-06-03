package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q0242 {
    public boolean isAnagram(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        String[] sToken = s.split("");
        String[] tToken = t.split("");

        if(s.length() != t.length()) return false;

        for(String token : sToken) {
            map.put(token, map.getOrDefault(token, 0) + 1);
        }

        for(String token : tToken) {
            if(map.containsKey(token) && map.get(token) != 0){
                map.put(token, map.get(token) - 1);
                continue;
            }
            return false;
        }

        return true;
    }
}
