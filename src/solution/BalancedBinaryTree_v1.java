package solution;

/**
 * leetcode_110_平衡二叉树
 * @author Chenzf
 * @date 2020/7/12
 * @version 1.0 自顶向下递归
 */

public class BalancedBinaryTree_v1 {
    /**
     * Recursively obtain the height of a tree.
     * An empty tree has -1 height
     */
    private int height(TreeNode node) {
        // An empty tree has height -1
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced(TreeNode node) {
        // An empty tree satisfies the definition of a balanced tree
        if (node == null) {
            return true;
        }

        // Check if subtrees have height within 1.
        // If they do, check if the subtrees are balanced
        return Math.abs(height(node.left) - height(node.right)) < 2
                && isBalanced(node.left) && isBalanced(node.right);
    }
}
