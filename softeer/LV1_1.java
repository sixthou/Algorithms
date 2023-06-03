package softeer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LV1_1 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=1016
     * 입력예제1
     * 3500 2000
     * 출력예제1
     * A
     * 입력예제2
     * 1500 1800
     * 출력예제2
     * B
     * 입력예제3
     * 5000 5000
     * 출력예제3
     * same
     */

    public void solution()
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .boxed()
                .collect(Collectors.toList());

        int A = nums.get(0);
        int B = nums.get(1);
        if (A == B) {
            System.out.println("same");
        } else if (A > B) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }

    }


}
