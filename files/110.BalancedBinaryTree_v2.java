package solution;

/**
 * leetcode_110_平衡二叉树
 * @author Chenzf
 * @date 2020/7/12
 * @version 2.0 自底向上递归
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode node) {
        return isBalancedTreeHelper(node).balanced;
    }

    /**
     * Return whether or not the tree at root is balanced while also storing
     * the tree's height in a reference variable.
     */
    private TreeInfo isBalancedTreeHelper(TreeNode node) {
        // An empty tree is balanced and has height = -1
        if (node == null) {
            return new TreeInfo(-1, true);
        }

        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(node.left);
        if (! left.balanced) {
            return new TreeInfo(-1, false);
        }

        TreeInfo right = isBalancedTreeHelper(node.right);
        if (! right.balanced) {
            return new TreeInfo(-1, false);
        }

        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }

        return new TreeInfo(-1, false);
    }
}

/**
 * Utility class to store information from recursive calls
 */
final class TreeInfo {
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}