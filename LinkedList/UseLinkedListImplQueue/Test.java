package cn.delingw.LinkedList.LinkedList.UseLinkedListImplQueue;

/**
 * @author delingw
 * @version 1.0
 * 链表实现栈测试
 */
public class Test {
    public static void main(String[] args) {
        IQueue<Integer> queue = new UseLinkedListImplQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        // 出队
        queue.dequeue();
        System.out.println(queue);
    }
}
