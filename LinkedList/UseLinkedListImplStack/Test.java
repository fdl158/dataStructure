package cn.delingw.LinkedList.LinkedList.UseLinkedListImplStack;

/**
 * @author delingw
 * @version 1.0
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        UseLinkedListImplStack<Integer> stack = new UseLinkedListImplStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println("获取栈顶结点:  " + stack.peek());
        System.out.println("出栈:  " + stack.pop());
        System.out.println(stack);
        System.out.println("是否为空 " + stack.isEmpty());
    }
}
