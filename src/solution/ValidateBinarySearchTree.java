package solution;

import java.util.Stack;

/**
 * leetcode_98_验证二叉搜索树
 * @author Chenzf
 * @date 2020/7/11
 * @version 1.0
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        // int inorder = - Integer.MAX_VALUE;
        // 需要一个很大的负数，防止第一个数满足if (node.val <= inorder)
        double inorder = - Double.MAX_VALUE;

        while (! stack.isEmpty() || node != null) {
            // 找到整棵树最左侧的结点
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            // 这里需要初始时inorder是一个很小的数
            if (node.val <= inorder) {
                return false;
            }

            inorder = node.val;
            node = node.right;
        }

        return true;
    }
}
