package com.sixthou;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q0020_Valid_Parentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid2("(])"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();
            st.push(s.charAt(0));

            for(int i = 1; i<s.length();i++){
                if(s.charAt(i) == '(' || s.charAt(i) == '{' ||s.charAt(i) == '[' ){
                    st.push(s.charAt(i));
                }else if(s.charAt(i) == ')' && st.peek() =='('){
                    st.pop();
                }else if(s.charAt(i) == ']' && st.peek() == '['){
                    st.pop();
                }else if(s.charAt(i) == '}' && st.peek() == '{'){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }

            if(st.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
        public boolean isValid2(String s){
            Map<Character, Character > brackets = new HashMap<>();
            brackets.put('}', '{');
            brackets.put(']', '[');
            brackets.put(')', '(');

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!brackets.containsKey(c)) {
                    stack.push(c);
                } else {
                    char top = stack.isEmpty() ? '?' : stack.pop();
                    if (top != brackets.get(c)) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
