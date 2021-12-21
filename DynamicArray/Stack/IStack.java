package cn.delingw.DynamicArray.Stack;

/**
 * @author delingw
 * @version 1.0
 * // 封装栈 接口
 * 先进后出 FILO
 */
public interface IStack<E> {

    // 进栈
    void push(E e);

    // 出栈
    E pop();

    // 获取栈顶元素
    E peek();

    // 判断栈是否为空
    boolean isEmpty();

    // 获取栈大小
    int getSize();

}
