package cn.delingw.DynamicArray.LoopQueueUpdate.V1;

/**
 * @author delingw
 * @version 1.0
 * 循环队列接口
 * 环形结构
 */
public interface ILoopQueueUpdateV1<E> {
    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //获取队头
    E getFront();

    // 判断队列是否为空
    boolean isEmpty();

    //获取队列中元素个数
    int getSize();

}
