package cn.delingw.LeetCode.RemoveLinkedListElem203.UseHead;

/**
 * @author delingw
 * @version 1.0
 * 移除链表元素 203题(使用虚拟头结点)
 * 不需要特殊处理
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        // 创建虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        //虚拟头结点的下一节点指向head
        dummyNode.next = head;
        //获取要删除的前指针
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 要删除的结点
                ListNode removeElem = prev.next;
                // 前指针的next 指向 删除结点的next
                prev.next = removeElem.next;
                removeElem.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode node = new Solution2().removeElements(head, val);
        System.out.println(node);
    }
}
