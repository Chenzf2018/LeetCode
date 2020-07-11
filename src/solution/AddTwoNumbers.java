package solution;

/**
 * leetcode_2_两数相加，与“leetcode_67_二进制求和”相似
 * @author Chenzf
 * @date 2020/7/11
 * @version 1.0
 */

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode (int val) {
            this.val =val;
        }

        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        // 进位标志
        int carry = 0;
        ListNode dummyHead = new ListNode(0, null);
        ListNode currentNode = dummyHead;

        while (listNode1 != null || listNode2 != null) {
            int sum = carry;
            sum += (listNode1 != null ? listNode1.val : 0);
            sum += (listNode2 != null ? listNode2.val : 0);

            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);

            currentNode = currentNode.next;
            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }

        // 两个链表都到达了尾端，此时进位值为1
        if (carry == 1) {
            currentNode.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
