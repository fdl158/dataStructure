package cn.delingw.DynamicArray;

/**
 * @author delingw
 * @version 1.0
 * 测试
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> data = new Array<>();
        data.addFirst(1);
        data.addLast(2);
        data.addLast(3);
        data.addLast(4);
        data.addLast(6);
        data.add(4, 5);
        data.addLast(7);
        data.addLast(8);
        data.addLast(9);
        data.addLast(10);
        data.addLast(11);
        data.addLast(12);
        System.out.println(data);
    }
}
