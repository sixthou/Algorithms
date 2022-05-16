package codility;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Rectangle {

    public int solution(int N){
        int sqlt = (int) Math.sqrt(N);
        List<pair> list = new ArrayList<>();
        for (int i = 1; i <= sqlt; i++) {
            if (N % i == 0) {
                if((N % (N/i) ==0)){
                    list.add(new pair(i, N / i ));
                }
            }
        }
        int ans = list.get(0).perimeter();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).perimeter() < ans) {
                ans = list.get(i).perimeter();
            }
        }
        return ans;
    }

    class pair {
        int A;
        int B;

        pair(int a, int b) {
            this.A = a;
            this.B = b;
        }

        public int perimeter() {
            return 2 * (A + B);
        }

    }

    @Test
    void test1() {
        Assertions.assertThat(solution(30)).isEqualTo(22);
    }

    @Test
    void test2() {
        Assertions.assertThat(solution(1)).isEqualTo(4);
    }

    @Test
    void test3() {
        Assertions.assertThat(solution(100)).isEqualTo(40);
    }
}
