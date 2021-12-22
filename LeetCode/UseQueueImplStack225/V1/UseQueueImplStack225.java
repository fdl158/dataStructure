package cn.delingw.LeetCode.UseQueueImplStack225.V1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author delingw
 * @version 1.0
 * 225、题 用队列实现栈
 */
public class UseQueueImplStack225 {
    // 方法一
    private Queue<Integer> queue;

    public UseQueueImplStack225() {
        queue = new LinkedList<>();
    }
    // 时间复杂度O(n) 链表实现
    public void push(int x) {
        queue.add(x);
    }
    // 时间复杂度O(n)
    public int pop() {
        // 创建另外一个队列 queue2
        Queue<Integer> queue2 = new LinkedList<>();
        // 除了最后一个元素，将 queue 中的所有元素放入 queue2
        while (queue.size() > 1) {
            queue2.add(queue.remove());
        }
        // queue  中剩下的最后一个元素就是“栈顶”元素
        int ret = queue.remove();

        // 此时 queue 2 是整个数据结构存储的所有其他数据，赋值给 queue
        queue = queue2;

        // 返回“栈顶元素”
        return ret;
    }
    // 时间复杂度O(n)
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }
    // 时间复杂度O(1)
    public boolean empty() {
        return queue.isEmpty();
    }

}
