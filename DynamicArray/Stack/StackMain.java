package cn.delingw.Array.Stack;

import cn.delingw.Array.Stack.IStack;

/**
 * @author delingw
 * @version 1.0
 * 栈
 */
public class StackMain {
    public static void main(String[] args) {
        IStack<Integer> stack = new StackImpl<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
}
