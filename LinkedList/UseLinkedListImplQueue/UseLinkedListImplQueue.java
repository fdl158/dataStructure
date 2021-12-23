package cn.delingw.LinkedList.LinkedList.UseLinkedListImplQueue;

/**
 * @author delingw
 * @version 1.0
 * 为什么要用尾指针?
 * 因为栈是先进先出,而我们知道链表从头结点删除、添加都是O(1),而从尾结点添加、删除都是O(n)
 * 所以就设计出了尾指针  这样就使得尾结点的添加就是O(1),但是删除还是O(n),这样 我们就可以把头结点为队头,尾结点为队尾
 * 这里用不使用虚拟节点 (不需要在链表中间添加或者删除数据)
 */
public class UseLinkedListImplQueue<E> implements IQueue<E> {
    // 定义结点
    private class Node {
        private E e;
        private Node next;

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
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 队尾进队
    @Override
    public void enqueue(E e) {
        // 如果当前是空的话,就直接创建一个新的结点,然后把首尾指针都指向它
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            // 不为空  和下面一样的意思
//            Node node = new Node(e);
//            tail.next = node;
//            tail = tail.next;
            // 创建一个新的结点
            // 让tail的next指针指向这个新的结点
            // 最后让尾指针指向这个新节点,表示这个是最后一个元素
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    // 队头出队
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue failed.queue is Empty");
        }
        // 头指针指向的元素,就是我们要出队的数据
        Node removeNode = head;
        // 头指针指向删除结点的下一结点 类似head+1;
        head = removeNode.next;
        // 让删除结点的next不再指向下一节点,为了被GC回收
        removeNode.next = null;
        // 但是如果删了一节点后,后面没有结点了的话
        // 就说明没有结点了 这样的话 尾指针也就为null了,防止脏数据(用C语言的话说就是野指针)
        if (head == null) {
            tail = null;
        }
        return removeNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            buf.append(cur + "<-");
            cur = cur.next;
        }
        buf.append("NULL tail");
        return buf.toString();
    }
}
