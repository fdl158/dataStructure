package cn.delingw.LeetCode.UseStackImpQueue232.V1;

import java.util.Stack;

/**
 * @author delingw
 * @version 1.0
 * 利用栈实现队列
 * 栈顶是队首
 * push() O(n) (循环多次)
 * pop() O(1)
 * empty() O(1)
 * peek()  O(1)
 */
public class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            // 将stack栈顶的元素 放到stack2栈底
            stack2.push(stack.pop());
        }
        // 加到stack中
        stack.push(x);
        // 然后再把stack2中的复制到stack中
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }

    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
