package cn.delingw.LeetCode.RemoveLinkedListElem203.NoUseHead;

/**
 * @author delingw
 * @version 1.0
 * 移除链表元素 203题(不使用头结点)
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    // 传进一个数组
    public ListNode(int[] arr) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("arr is empty");
        }
        // 头结点的值为arr[0] 这个值
        this.val = arr[0];
        // 头结点  就是this
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            // 把数组的每个都用来创建一个新结点
            curNode.next = new ListNode(arr[i]);
            // 创建一个新结点,头指针就指向新的结点
            curNode = curNode.next;
        }
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        StringBuilder sbf = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sbf.append(cur.val + "->");
            cur = cur.next;
        }
        sbf.append("NULL");
        return sbf.toString();
    }
}
