package solution;

/**
 * @author Chenzf
 * @date 2020/7/25
 * @version 1.0 递归
 */

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        } else if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoLists(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoLists(listNode1, listNode2.next);
            return listNode2;
        }
    }
}
