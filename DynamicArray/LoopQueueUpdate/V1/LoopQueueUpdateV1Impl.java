package cn.delingw.DynamicArray.LoopQueueUpdate.V1;


/**
 * @author delingw
 * @version 1.0
 * 升级版,不浪费一个空间,使用size
 */
public class LoopQueueUpdateV1Impl<E> implements ILoopQueueUpdateV1<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueueUpdateV1Impl(int capacity) {
        // 不浪费一个空间
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueUpdateV1Impl() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
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

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E delElem = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //删除到了一定程度容量也减,防止(均摊)复杂度动荡,当元素删除到1/4时, 就把容量减半
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
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("loopQueueUpdate: size=%d , capacity=%d\n", size, getCapacity()));
        buf.append("front [");
        for (int i = 0; i < size; i++) {
            buf.append(data[(front + i) % data.length]);
            if ((i + front + 1) % data.length != tail)
                buf.append(", ");
        }
        buf.append("] tail");
        return buf.toString();
    }
}
