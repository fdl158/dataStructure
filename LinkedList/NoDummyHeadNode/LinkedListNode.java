package cn.delingw.LinkedList.LinkedList.NoDummyHeadNode;

/**
 * @author delingw
 * @version 1.0
 * 不带头结点
 */
public class LinkedListNode<E> {
    private class Node {
        private E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    // 头指针
    private Node head;
    // 链表中的元素数量
    private int size;

    public LinkedListNode() {
        head = null;
        size = 0;
    }

    // 判断是否为空链表
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取链表的个数
    public int getSize() {
        return size;
    }

    // 链表头添加元素
    public void addFirst(E e) {
//        Node node = new Node();
//        node.next = head;
//        head = node;
        //size++;
        // 上面的写法是一致
        head = new Node(e, head);
        size++;
    }

    // 链表中间添加元素
    public void add(int index, E e) {
        // 可以取到size,size就是在末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            // 从head头指针开始
            Node prev = head;
            // 要插入的索引前一个节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node();
//            node.next = prev.next;
//            prev.next = node;
            // 前一个节点的next 赋值给 新节点的next
            // 新节点赋值给前一个节点的next
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    // 末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }


}
