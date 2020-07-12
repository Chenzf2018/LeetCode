package solution;

import java.util.Set;
import java.util.HashSet;

/**
 * leetcode_968_监控二叉树：使用贪心算法
 * @author Chenzf
 * @date 2020/7/11
 * @version 1.0
 *
 *  Definition for a binary tree node.
 *  public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 *   }
 */

public class BinaryTreeCameras_v1 {
    private int result;
    private Set<TreeNode> covered;

    public int minCameraCover(TreeNode root) {
        result = 0;
        covered = new HashSet<>();
        covered.add(null);

        deepFirstSearch(root, null);

        return result;
    }

    public void deepFirstSearch(TreeNode node, TreeNode parent) {
        if (node != null) {
            deepFirstSearch(node.left, node);
            deepFirstSearch(node.right, node);

            boolean needCovered = (parent == null) && ! covered.contains(node)
                    || ! covered.contains(node.left) || ! covered.contains(node.right);

            if (needCovered) {
                result++;
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}
