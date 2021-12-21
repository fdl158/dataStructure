package cn.delingw.Array.Stack;

import cn.delingw.Array.ObjectArray.Array;


public class StackImpl<E> implements IStack<E> {
    private Array<E> array;

    public StackImpl() {
        array = new Array<>();
    }

    public StackImpl(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Stack:");
        buf.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            buf.append(array.get(i));
            if (i != array.getSize() - 1) {
                buf.append(',');
            }
        }
        buf.append(']');
        return buf.toString();
    }
}
