package solution;

/**
 * leetcode_206_反转链表
 * @author Chenzf
 * @date 2020/7/25
 * @version 2.0 递归
 */

public class ReverseLinkedList_v2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return curr;
    }
}
