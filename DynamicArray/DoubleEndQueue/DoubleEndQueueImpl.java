package cn.delingw.DynamicArray.DoubleEndQueue;

/**
 * @author delingw
 * @version 1.0
 * 双端队列实现类
 */
public class DoubleEndQueueImpl<E> implements IQueue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public DoubleEndQueueImpl(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    // 获取容量
    @Override
    public int getCapacity() {
        return data.length;
    }


    public DoubleEndQueueImpl() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //头插 需要考虑(新元素插在的索引位置)front-1前面的位置,如果front=0,则front-1=data.length-1
    @Override
    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    // 尾插和进队列一样
    @Override
    public void addTail(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // 扩容
    private void resize(int newCapacity) {
        E[] new_data = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            new_data[i] = data[(front + i) % data.length];
        }
        data = new_data;
        front = 0;
        tail = size;
    }

    // 头移除 和出队列一样
    @Override
    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from an empty queue.");
        }
        // 要移除的元素
        E delElem = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return delElem;
    }

    // 移除尾的元素
    // (解释:tail 是即将新元素要插入的索引位置),需要判断(tail-1的位置索引),如果tail=0,则上一个元素索引是data.length-1;
    @Override
    public E removeTail() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from an empty queue.");
        }
        tail = tail == 0 ? data.length - 1 : tail - 1;
        // 要删除的元素
        E delElem = data[tail];
        data[tail] = null;
        size--;
        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return delElem;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public E getTail() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        // 获取最后一个位置索引,和删除尾元素一样,需要判断tail-1的位置
        int lastIndex = tail == 0 ? data.length - 1 : tail - 1;
        return data[lastIndex];
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("DoubleEndQueue: size=%d  capacity=%d\n", size, getCapacity()));
        buf.append('[');
        for (int i = 0; i < size; i++) {
            buf.append(data[(front + i) % data.length]);
            if (i != size - 1) {
                buf.append(',');
            }
        }
        buf.append(']');
        return buf.toString();
    }
}
