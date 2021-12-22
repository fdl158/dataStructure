package cn.delingw.DynamicArray.LoopQueueUpdate.V1;

/**
 * @author delingw
 * @version 1.0
 * 循环队列测试类
 */
public class LoopQueueUpdateMain {
    public static void main(String[] args) {
        ILoopQueueUpdateV1<Integer> queue = new LoopQueueUpdateV1Impl<>();
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
