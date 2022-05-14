package codility;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Brackets {

    public int solution(String S) {
        int length = S.length();
        Stack<String> stack = new Stack<>();

        if (length == 0) {
            return 1;
        }

        for (int i = 0; i < length; i++) {
            if (stack.size() == 0) {
                stack.push(String.valueOf(S.charAt(i)));
            }else{
                String now = String.valueOf(S.charAt(i));
                if (now.equals("}")) {
                    if(stack.peek().equals("{")){
                        stack.pop();
                    }else{
                        stack.push(now);
                    }
                } else if (now.equals("]")) {
                    if(stack.peek().equals("[")){
                        stack.pop();
                    }else{
                        stack.push(now);
                    }
                } else if (now.equals(")")) {
                    if(stack.peek().equals("(")){
                        stack.pop();
                    }else{
                        stack.push(now);
                    }
                } else{
                    stack.push(now);
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(solution("{[()()]}"), 1);
    }

    @Test
    public void test2() {
        Assertions.assertEquals(solution("([)()]"), 0);
    }

    @Test
    public void test3() {
        String s = "asdfg";
        System.out.println(s.substring(3,3));
    }

}
