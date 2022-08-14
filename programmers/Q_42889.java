package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_42889 {

    public int[] solution(int N, int[] stages) {
        int[] cnts = new int[N + 1];
        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                cnts[j]++;
            }
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(new Point(i+1, (cnts[i] - cnts[i + 1]) / (double)cnts[i]));
        }
        Collections.sort(points);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = points.get(i).getIndex();
        }

        return answer;
    }

    class Point implements Comparable<Point> {
        int index;

        double rate;

        @Override
        public int compareTo(Point o) {

            if(o.rate > this.rate){
                return 1;
            } else if (o.rate < this.rate) {
                return -1;
            } else {
                return 0;
            }
        }

        public int getIndex() {
            return index;
        }

        public double getRate() {
            return rate;
        }

        public Point(int index, double rate) {
            this.index = index;
            this.rate = rate;
        }

    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(int num, int[] stage , int[] expect) {
        Assertions.assertThat(solution(num, stage)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
            Arguments.of(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}, new int[]{3, 4, 2, 1, 5}),
            Arguments.of(4, new int[]{4, 4, 4, 4, 4}, new int[]{4, 1, 2, 3})
        );
    }

}
