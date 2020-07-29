package solution;

/**
 * leetcode_543_二叉树的直径
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0
 */

public class DiameterOfBinaryTree {
    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        depthOfNode(root);
        return result - 1;
    }

    public int depthOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depthOfNode(node.left);
        int rightDepth = depthOfNode(node.right);
        result = Math.max(result, leftDepth + rightDepth + 1);

        // 返回以该节点为根的子树的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
