package codility;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

public class CountFactors {

    public int solution(int N) {
        int sqlt = (int) Math.sqrt(N);
        int ans = 0;
        for (int i = 1; i <= sqlt; i++) {
            if (N % i == 0) {
                ans++;
            }
        }
        ans *= 2;
        if (sqlt * sqlt == N) {
            ans--;
        }
        return ans;
    }
}
