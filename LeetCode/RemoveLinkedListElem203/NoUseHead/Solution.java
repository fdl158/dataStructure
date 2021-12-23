package cn.delingw.LeetCode.RemoveLinkedListElem203.NoUseHead;

/**
 * @author delingw
 * @version 1.0
 * 带头结点(特殊处理)
 * 移除链表元素 203题
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 如果链表不为null,并且第一个结点的val就和val一致的话,就删除
        // 因为可能第一个删除了,后面的第一个还是满足val==val 所以用while
        while (head != null && head.val == val) {
            // removeElem指向要删除的结点
            ListNode removeElem = head;
            head = removeElem.next;
            removeElem.next = null;
//            head = head.next;
        }
        if (head == null)
            return null;

        // 处理中间的元素(找到要删除结点的前指针),从head循环
        ListNode prev = head;
        // 一直判断下个节点是不是为null
        while (prev.next != null) {
            // 如果下一个节点的val ==val,就删掉
            if (prev.next.val == val) {
                //removeElem指向要删除的结点
                ListNode removeElem = prev.next;
                prev.next = removeElem.next;
                removeElem.next = null;
                // prev.next=prev.next.next;
                // 有可能下一个节点还是要删除的结点
            }
//            prev = prev.next;
            // 如果下一个节点不是要删的结点,就指向下一个,所以不能省略else{}
            else {
                prev = prev.next;
            }
        }
        return head;
    }

    // 测试
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        // 创建一个头结点
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode node = new Solution().removeElements(head, val);
        System.out.println(node);
    }
}
