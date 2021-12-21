package cn.delingw.DynamicArray.LoopQueue;

/**
 * @author delingw
 * @version 1.0
 * 循环队列测试类
 */
public class LoopQueueMain {
    public static void main(String[] args) {
        ILoopQueue<Integer> queue = new LoopQueueImpl<>();
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
