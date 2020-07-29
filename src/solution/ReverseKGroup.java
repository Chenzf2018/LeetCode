package solution;

/**
 * leetcode_25. K个一组翻转链表
 * @author Chenzf
 * @date 2020/7/25
 * @version 1.0
 */

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode start = prev.next;
            // 下一组的开始
            ListNode nextNode = end.next;
            // 一组结束
            end.next = null;
            // 此时prev指向反转后的链表头
            prev.next = reverse(start);

            start.next = nextNode;
            prev = start;
            // 此时end在下一组的开始
            end = prev;
        }

        return dummy.next;
    }

    /**
     * 链表反转leetcode_206
     */
    private ListNode reverse(ListNode head) {
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
