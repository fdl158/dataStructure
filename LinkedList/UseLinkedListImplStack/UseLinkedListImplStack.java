package cn.delingw.LinkedList.LinkedList.UseLinkedListImplStack;

import cn.delingw.LinkedList.LinkedList.DummyHeadNode.LinkedListDummyHeadNode;

/**
 * @author delingw
 * @version 1.0
 * 用单链表实现栈
 * 头插 头出
 */
public class UseLinkedListImplStack<E> implements IStack<E> {
    private LinkedListDummyHeadNode<E> dummyHeadNode;

    public UseLinkedListImplStack() {
        dummyHeadNode = new LinkedListDummyHeadNode<>();
    }

    @Override
    public void push(E e) {
        dummyHeadNode.addFirst(e);
    }

    @Override
    public E pop() {
        return dummyHeadNode.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return dummyHeadNode.isEmpty();
    }

    @Override
    public E peek() {
        return dummyHeadNode.getFirst();
    }

    @Override
    public int getSize() {
        return dummyHeadNode.getSize();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("LinkedListImplStack:  ");
        buf.append(dummyHeadNode);
        return buf.toString();
    }
}
