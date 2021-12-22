package cn.delingw.DynamicArray.LoopQueueUpdate.V2;


/**
 * @author delingw
 * @version 1.0
 * 升级版,不使用size 但是浪费一个空间
 */
public class LoopQueueUpdateV2Impl<E> implements ILoopQueueUpdateV2<E> {
    private E[] data;
    private int front;
    private int tail;

    public LoopQueueUpdateV2Impl(int capacity) {
        // 浪费一个空间 不使用size
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    // 多注意这个:
    // 不使用size 计算公式
    // 可以画图
    // tail>=front= tail-front
    // tail<front =tail-front/data.length
    @Override
    public int getSize() {
        return tail >= front ? tail - front : tail - front / data.length;
    }


    public LoopQueueUpdateV2Impl() {
        this(10);
    }

    // 实际放元素容量
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    // 扩容
    private void resize(int newCapacity) {
        E[] new_data = (E[]) new Object[newCapacity + 1];
        // 获取大小
        int size = getSize();
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
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return delElem;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("loopQueueUpdate: size=%d , capacity=%d\n", getSize(), getCapacity()));
        buf.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            buf.append(data[i]);
            if ((i + 1) % data.length != tail) {
                buf.append(',');
            }
        }
        buf.append("] tail");
        return buf.toString();
    }
}
