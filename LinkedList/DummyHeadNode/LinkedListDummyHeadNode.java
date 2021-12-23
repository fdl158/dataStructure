package cn.delingw.LinkedList.LinkedList.DummyHeadNode;

/**
 * @author delingw
 * @version 1.0
 * 带头结点
 */
public class LinkedListDummyHeadNode<E> {
    private class Node {
        public E e;
        public Node next;

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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListDummyHeadNode() {
        // 创建一个虚拟头结点
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中的元素个数(O(1))
    public int getSize() {
        return size;
    }

    // 返回链表是否为空(O(1))
    public boolean isEmpty() {
        return size == 0;
    }


    // 链表任何一个地方插入元素(头结点插入O(1)、尾结点插入O(n))
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        // 注意:这里是从虚拟头结点开始循环的,所以小于index
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在头结点插入元素(时间复杂度O(1))
    public void addFirst(E e) {
        add(0, e);
    }

    // 在尾结点插入元素(时间复杂度O(n)、先遍历,后添加,链表不具备随机访问)
    public void addLast(E e) {
        add(size, e);
    }

    // 查询(复杂度:头结点O(1) 尾结点O(n) 平均复制度O(n))
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Illegal index.");
        }
        // curNode 用来指向我们要操作的元素
        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.e;
    }

    // 查询头结点(O(1))
    public E getFirst() {
        return get(0);
    }

    // 查询尾结点(O(n))
    public E getLast() {
        return get(size - 1);
    }

    // 链表中是否包含这个元素(平均复杂度O(n)和查询一样)
    public boolean contains(E e) {
        Node curNode = dummyHead.next;
        while (curNode != null) {
            if (curNode.equals(e)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    // 更新结点中的数据(平均复杂度O(n)和查询一样)
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Illegal index.");
        }
        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.e = e;
    }

    //删除链表中的数据(头结点O(1)、尾结点O(n)、平均复杂度O(n))
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        // 找出删除结点的前节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //要删除的结点
        Node delNode = prev.next;
        //前节点的next指针指向要删除结点的下一个节点
        prev.next = delNode.next;
        //让删除的结点的next指针不再指向下一个节点
        delNode.next = null;
        size--;
        return delNode.e;
    }

    // 删除头结点(O(1))
    public E removeFirst() {
        return remove(0);
    }

    // 删除尾结点(O(n))
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("带虚拟头结点: size:%d\n", size));
        // 遍历
        // 写法一
//        Node curNode = dummyHead.next;
//        while (curNode != null) {
//            buf.append(curNode + "->");
//            curNode = curNode.next;
//        }
//        buf.append("NULL");
        // 写法二
        for (Node curNode = dummyHead.next; curNode != null; curNode = curNode.next) {
            buf.append(curNode + "->");
        }
        buf.append("NULL");
        return buf.toString();
    }
}
