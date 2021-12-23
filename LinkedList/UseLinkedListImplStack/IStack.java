package cn.delingw.LinkedList.LinkedList.UseLinkedListImplStack;

/**
 * @author delingw
 * @version 1.0
 * 栈接口
 */
public interface IStack<E> {
    // 进栈
    void push(E e);

    // 出栈
    E pop();

    // 是否为空
    boolean isEmpty();

    // 栈顶元素
    E peek();

    // 获取大小
    int getSize();

}
