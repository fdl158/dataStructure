package cn.delingw.DynamicArray.DoubleEndQueue;

/**
 * @author delingw
 * @version 1.0
 * 双端队列接口
 */
public interface IQueue<E> {
    //从队头添加
    void addFront(E e);

    // 从队尾添加
    void addTail(E e);

    // 从队头删除
    E removeFront();

    // 从队尾删除
    E removeTail();

    // 获取队头元素
    E getFront();

    // 获取队尾元素
    E getTail();

    // 是否为空
    boolean isEmpty();

    // 获取队列容量
    int getCapacity();

}
