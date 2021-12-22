package cn.delingw.LeetCode.UseQueueImplStack225.V4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author delingw
 * @version 1.0
 * 使用一个队列
 */
public class UseQueueImplStack225 {
    private Queue<Integer> queue;

    public UseQueueImplStack225() {
        queue = new LinkedList<>();
    }

    // 时间复杂度O(n)
    public void push(int x) {
        // 将新的元素加入队列尾
        queue.add(x);
        // 让前面的元素出队,然后再入队
        // 例如(执行n-1) 5为栈顶元素
        // 1 2 3 4 5
        // 2 3 4 5 1
        // 3 4 5 1 2
        // 4 5 1 2 3
        // 5 1 2 3 4
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
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
