package cn.delingw.LeetCode.LC206;

/**
 * @author delingw
 * @version 1.0
 * 反转链表 206
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 非递归方式
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
    // 递归方式
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
