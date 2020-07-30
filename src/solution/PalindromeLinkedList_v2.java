package solution;

/**
 * leetcode_234_回文链表
 * @author Chenzf
 * @date 2020/7/30
 * @version 2.0 将链表的后半部分反转
 */

public class PalindromeLinkedList_v2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the end of first half
        ListNode firstHalfEnd = findEndOfFirstHalf(head);
        // Reverse second half
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode point1 = head;
        ListNode point2 = secondHalfStart;
        boolean result = true;

        while (result && point2 != null) {
            if (point1.val != point2.val) {
                result = false;
            }

            point1 = point1.next;
            point2 = point2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    /**
     * 使用快慢指针在一次遍历中找到：慢指针一次走一步，快指针一次走两步，快慢指针同时出发。
     * 当快指针移动到链表的末尾时，慢指针到链表的中间。通过慢指针将链表分为两部分。
     */
    private ListNode findEndOfFirstHalf(ListNode head) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;
        while (fastPoint.next != null && fastPoint.next.next != null) {
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
        }

        return slowPoint;
    }

    /**
     * 反转链表
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
