package cn.delingw.Array.Queue;

import cn.delingw.Array.ObjectArray.Array;

/**
 * @author delingw
 * @version 1.0
 */
public class QueueImpl<E> implements IQueue<E> {
    private Array<E> array;

    public QueueImpl() {
        array = new Array<>();
    }

    public QueueImpl(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("queue:");
        buf.append("front[");
        for (int i = 0; i < array.getSize(); i++) {
            buf.append(array.get(i));
            if (i != array.getSize() - 1) {
                buf.append(',');
            }
        }
        buf.append("]tail");
        return buf.toString();
    }
}
