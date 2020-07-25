package solution;

/**
 * leetcode_206_反转链表
 * @author Chenzf
 * @date 2020/7/25
 * @version 1.0 迭代
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
