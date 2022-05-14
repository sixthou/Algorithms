package codility;


import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Nesting {

    public int solution(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String s = String.valueOf(S.charAt(i));
            if (!stack.isEmpty() && s.equals(")") && stack.peek().equals("(")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution("(()(())())"), 1);
    }

    @Test
    void test1() {
        Assertions.assertEquals(solution(""), 1);
    }

    @Test
    void test2() {
        Assertions.assertEquals(solution("()"), 1);
    }

    @Test
    void test3() {
        Assertions.assertEquals(solution("("), 0);
    }

    @Test
    void test4() {
        Assertions.assertEquals(solution("("), 0);
    }

    @Test
    void test5() {
        Assertions.assertEquals(solution("())"), 0);
    }


}
