package cn.delingw.LinkedList.LinkedList.DummyHeadNode;


/**
 * @author delingw
 * @version 1.0
 * 带头结点测试类
 */
public class Test {
    public static void main(String[] args) {
        LinkedListDummyHeadNode<Integer> dummyHeadNode = new LinkedListDummyHeadNode<>();
        for (int i = 0; i < 5; i++) {
            dummyHeadNode.addFirst(i);
            System.out.println(dummyHeadNode);
        }
        dummyHeadNode.add(3, 333);
        System.out.println(dummyHeadNode);
        System.out.println("在头结点添加元素");
        dummyHeadNode.addFirst(111111);
        System.out.println(dummyHeadNode);
        System.out.println("获取索引为3的结点  " + dummyHeadNode.get(3));
        System.out.println("头结点 " + dummyHeadNode.getFirst());
        System.out.println("尾结点 " + dummyHeadNode.getLast());
        System.out.println("设置索引位置为2的元素为222");
        dummyHeadNode.set(2, 222);
        System.out.println(dummyHeadNode);
        System.out.println("删除索引位置为2的元素");
        dummyHeadNode.remove(2);
        System.out.println(dummyHeadNode);
        System.out.println("删除头元素");
        dummyHeadNode.removeFirst();
        System.out.println(dummyHeadNode);
        System.out.println("删除尾元素");
        dummyHeadNode.removeLast();
        System.out.println(dummyHeadNode);
    }
}
