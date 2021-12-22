package cn.delingw.DynamicArray.LoopQueueUpdate.V2;

/**
 * @author delingw
 * @version 1.0
 * 循环队列测试类
 */
public class LoopQueueUpdateMain {
    public static void main(String[] args) {
        ILoopQueueUpdateV2<Integer> queue = new LoopQueueUpdateV2Impl<>();
        for (int i = 0; i < 11; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
