package softeer;

import java.util.Scanner;

public class LV1_2 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=990
     * 입력예제1
     * 10:00 19:00
     * 09:00 15:00
     * 10:00 11:00
     * 11:00 22:00
     * 09:00 15:00
     * 출력예제1
     * 1980
     * 월요일에 9시간, 화요일에 6시간, 수요일에 1시간, 목요일에 11시간, 금요일에 6시간을 근무하였다. 총 근무 시간은 9 + 6 + 1 + 11 + 6 = 33시간, 즉 33 × 60 = 1980분이다.
     *
     * 입력예제2
     * 09:17 18:34
     * 09:17 18:34
     * 09:17 18:34
     * 09:17 18:34
     * 09:17 18:34
     * 출력예제2
     * 2785
     * 매일 9시간 17분을 근무하였으므로, 5일간 46시간 25분을 근무하였다.
     *
     * 입력예제3
     * 09:17 19:24
     * 10:11 18:45
     * 09:34 18:27
     * 10:47 15:33
     * 08:47 18:32
     * 출력예제3
     * 2525
     */

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        while(sc.hasNext()){
            answer += calWorkingTime(sc.nextLine());
        }

        System.out.println(answer);

    }

    private static int calWorkingTime(String s){
        String times[] = s.split(" ");
        return timeToMinute(times[1]) - timeToMinute(times[0]);

    }

    private static int timeToMinute(String time){
        String token[] = time.split(":");
        return Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]);
    }
}
