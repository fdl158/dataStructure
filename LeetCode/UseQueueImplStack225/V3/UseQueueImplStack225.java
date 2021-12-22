package cn.delingw.LeetCode.UseQueueImplStack225.V3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author delingw
 * @version 1.0
 * 队列首作为栈顶
 */
public class UseQueueImplStack225 {
    private Queue<Integer> queue;

    public UseQueueImplStack225() {
        queue = new LinkedList<>();
    }

    // 时间复杂度O(n)
    public void push(int x) {
        // 创建新的队列
        Queue<Integer> queue2 = new LinkedList<>();
        // 新的数据先给到queue2
        queue2.add(x);
        // 然后把queue中的数据复制给queue2
        while (!queue.isEmpty()) {
            queue2.add(queue.remove());
        }
        // 最后复制
        queue = queue2;
    }

    // 时间复杂度O(n)升级为O(1)
    public int pop() {
        return queue.remove();
    }

    //从时间复杂度O(n)--->时间复杂度O(1)
    public int top() {
        return queue.peek();
    }

    // 时间复杂度O(1)
    public boolean empty() {
        return queue.isEmpty();
    }

}
