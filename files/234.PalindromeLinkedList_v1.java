package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_234_回文链表
 * @author Chenzf
 * @date 2020/7/30
 * @version 1.0 将值复制到数组中后用双指针法
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arrayList = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            arrayList.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int left = 0, right = arrayList.size() - 1;
        while (left < right) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (! arrayList.get(left).equals(arrayList.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
