package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode_144_二叉树的前序遍历
 * @author Chenzf
 * @date 2020/7/26
 * @version 2.0 迭代法
 */

public class PreorderTraversal_v2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        // 从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中
        stack.add(root);
        while (! stack.isEmpty()) {
            // 每次迭代弹出当前栈顶元素
            TreeNode node = stack.pollLast();
            output.add(node.val);

            // 先压右孩子
            if (node.right != null) {
                stack.add(node.right);
            }

            // 再压左孩子
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return output;
    }
}
