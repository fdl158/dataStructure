package cn.delingw.DynamicArray.LoopQueue;

/**
 * @author delingw
 * @version 1.0
 * 循环队列接口
 * 环形结构
 */
public interface ILoopQueue<E> {
    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //获取队头
    E getFont();

    // 判断队列是否为空
    boolean isEmpty();

    //获取队列中元素个数
    int getSize();

}
