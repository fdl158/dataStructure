package cn.delingw.DynamicArray.Queue;

/**
 * @author delingw
 * @version 1.0
 * 封装队列 先进先出 FIFO
 */
public interface IQueue<E> {

    // 获取队列大小
    int getSize();
    // 判断队列是否为空
    boolean isEmpty();
    // 进队列
    void enqueue(E e);
    // 出队列
    E dequeue();
    // 获取队头
    E getFront();
}
