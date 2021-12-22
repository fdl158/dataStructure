package cn.delingw.DynamicArray.DoubleEndQueue;

/**
 * @author delingw
 * @version 1.0
 * 双端队列测试类
 */
public class Test {
    public static void main(String[] args) {
        IQueue<Integer> queue = new DoubleEndQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            // 尾插
            queue.addTail(i);
        }
        System.out.println(queue);
        // 头插
        queue.addFront(5);
        System.out.println(queue);
        // 尾移
        queue.removeTail();
        System.out.println(queue);
        // 头移
        queue.removeFront();
        System.out.println(queue);
        // 获取头元素
        System.out.println(queue.getFront());
        // 获取尾元素
        System.out.println(queue.getTail());
        // 试试移除缩容
        queue.removeFront();
        queue.removeFront();
        queue.removeFront();
        queue.removeFront();
        queue.removeFront();
        System.out.println(queue);
    }
}
