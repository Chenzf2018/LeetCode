package solution;

/**
 * @author Chenzf
 * @date 2020/7/25
 * @version 2.0 迭代
 */

public class MergeTwoSortedList_v2 {
    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                prev.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                prev.next = listNode2;
                listNode2 = listNode2.next;
            }

            prev = prev.next;
        }

        // 此时l1和l2只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = (listNode1 == null) ? listNode2 : listNode1;

        return preHead.next;
    }
}
