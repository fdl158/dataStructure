package cn.delingw.Array.Queue;

/**
 * @author delingw
 * @version 1.0
 */
public class QueueMain {
    public static void main(String[] args) {
        IQueue<Integer> queue = new QueueImpl<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
