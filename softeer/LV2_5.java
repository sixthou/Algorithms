package softeer;

import java.util.Scanner;

public class LV2_5 {
    /**
     * https://softeer.ai/practice/info.do?idx=1&eid=623
     * 입력예제1
     * 3 10 5
     * 1 4 5
     * 3 3 1 2 4 1 4 5 1 4
     * 출력예제1
     * secret
     * 비밀 메뉴 조작에 해당하는 부분을 표시하면 다음과 같다:
     *
     *
     *
     *     3 3 1 2 4 [1 4 5] 1 4
     *
     * 입력예제2
     * 4 10 3
     * 2 1 3 2
     * 1 3 2 1 3 2 1 3 2 1
     * 출력예제2
     * secret
     * 비밀 메뉴 조작이 두 번 나타났다:
     *
     *
     *
     *     1 3 [2 1 3 2] 1 3 2 1
     *
     *     1 3 2 1 3 [2 1 3 2] 1
     *
     *
     *
     * 비밀 메뉴 조작이 두 번 이상 나타나고 심지어 위의 예시와 같이 서로 겹치게 나타나더라도 정상적인 비밀 메뉴 조작으로 인정된다.
     *
     * 입력예제3
     * 4 10 9
     * 2 7 1 8
     * 3 1 4 1 5 9 2 6 5 3
     * 출력예제3
     * normal
     * 비밀 메뉴 조작 2 7 1 8이 나타나지 않았으므로 정상적인 식권이 발매된다.
     *
     * 입력예제4
     * 4 3 5
     * 1 2 3 4
     * 3 2 1
     * 출력예제4
     * normal
     * 사용자의 버튼 조작이 비밀 메뉴 조작법보다 짧은 경우가 있을 수 있다.
     *
     * 이 경우 정상적인 식권이 발매된다. 즉, N＜M인 경우도 가능하다.
     */

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        String secret = sc.nextLine().replaceAll(" ","");
        String menu = sc.nextLine().replaceAll(" ","");


        String answer = menu.contains(secret) ? "secret" : "normal";
        System.out.println(answer);
    }
}
