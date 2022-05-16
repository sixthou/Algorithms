package codility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChocolatesByNumbers {
    public int solution(int N, int M) {
        int gcd = GCD(N, M);
        return N / gcd;
    }

    int GCD(int a, int b)
    {
        if(b==0)return a;
        else return GCD(b,a%b);
    }

    @Test
    void test1() {
        Assertions.assertThat(solution(10, 4)).isEqualTo(5);
    }

    @Test
    void test2() {
        Assertions.assertThat(solution(1, 1)).isEqualTo(1);
    }

}
