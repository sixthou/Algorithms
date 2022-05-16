package codility;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
    public int solution(int[] A){
        Set<Integer> set = new HashSet<>();
        for (final int j : A) {
            set.add(Math.abs(j));
        }
        return set.size();
    }

}
