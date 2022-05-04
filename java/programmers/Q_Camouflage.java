package programmers;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q_Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i <clothes.length ; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String key : map.keySet()){
               answer *= (map.get(key)+1);
        }

        return answer-1;
    }

    @Test
    public void test1(){
        Assertions.assertEquals(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}), 5);
    }

    @Test
    public void test2(){
        Assertions.assertEquals(solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}), 3);
    }
}
