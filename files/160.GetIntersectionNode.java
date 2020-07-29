package solution;

/**
 * leetcode_160_相交链表
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0
 */

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointA = headA, pointB = headB;
        // 速度相同，走过相同的路，且有交点，则注定会相遇
        while (pointA != pointB) {
            pointA = (pointA == null) ? headB : pointA.next;
            pointB = (pointB == null) ? headA : pointB.next;
        }

        return pointA;
    }
}
