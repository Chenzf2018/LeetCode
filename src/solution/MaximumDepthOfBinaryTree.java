package solution;

/**
 * leetcode_104_二叉树最大深度
 * 使用递归
 * @author Chenzf
 * @date 2020/7/11
 * @version 1.0
 *
 * Definition for a binary tree node.
 *
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(node.left);
            int rightHeight = maxDepth(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
