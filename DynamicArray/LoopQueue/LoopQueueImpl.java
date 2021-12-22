package cn.delingw.DynamicArray.LoopQueue;

/**
 * @author delingw
 * @version 1.0
 * 循环队列实现类
 * 这里说的指针和java引用是一样的概念
 */
public class LoopQueueImpl<E> implements ILoopQueue<E> {
    // 队列数据
    private E[] data;
    // 头指针
    private int front;
    // 尾指针(即将要插入元素的位置)
    private int tail;
    // 队列元素数量指针
    private int size;


    // 给定容量
    public LoopQueueImpl(int capacity) {
        //为了解决队列满和队列空都一样的问题,就多设置了一个空间
        // 注意这里object 是每个类的基类,不然会出现自动转换数据类型失败,教训.idea自动导包。。。。
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    // 默认容量
    public LoopQueueImpl() {
        this(10);
    }

    // 获取队列中实际容量
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {

        // 队满,扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        // 添加元素
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // 扩容方法
    private void resize(int newCapacity) {
        E[] new_data = (E[]) new Object[newCapacity + 1];
        //旧数组data[font]位置的数据对应新数组new_data[0]位置上
        for (int i = 0; i < size; i++) {
            new_data[i] = data[(i + front) % data.length];
        }
        data = new_data;
        front = 0;
        // size=5,tail->data[5];
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        //要出队的元素
        E elem = data[front];
        // 方便回收
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //删除到了一定程度容量也减,防止(均摊)复杂度动荡,当元素删除到1/4时, 就把容量减半
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return elem;
    }

    @Override
    public E getFront() {
        return data[front];
    }


    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("loopQueue: size=%d , capacity=%d\n", getSize(), getCapacity()));
        buf.append("font [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            buf.append(data[i]);
            if ((i + 1) % data.length != tail) {
                buf.append(", ");
            }
        }
        buf.append("] tail");
        return buf.toString();
    }

}

