package cn.delingw.LeetCode.Stack20;

import java.util.Stack;

/**
 * @author delingw
 * @version 1.0
 * 20题、有效的括号
 */
public class Stack20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topE = stack.pop();
                if (c == ')' && topE != '(') {
                    return false;
                }
                if (c == '}' && topE != '{') {
                    return false;
                }
                if (c == ']' && topE != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack20 stack20 = new Stack20();
        String s = "()[]{}";
        String s2 = "(]";
        System.out.println(stack20.isValid(s));
        System.out.println(stack20.isValid(s2));
    }
}
