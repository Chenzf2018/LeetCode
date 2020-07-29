package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode_145_二叉树的后序遍历
 * @author Chenzf
 * @date 2020/7/26
 * @version 2.0 迭代
 */

public class PostorderTraversal_v2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);
        while (! stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            // 每次在链表的头部插入元素
            output.addFirst(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return output;
    }
}
