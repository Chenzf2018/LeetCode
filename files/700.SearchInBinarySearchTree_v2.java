package solution;

/**
 * leetcode_700_二叉搜索树中的搜索
 * @author Chenzf
 * @date 2020/7/12
 * @version 2.0 迭代
 */

public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode node, int value) {
        while (node != null && value != node.val) {
            node = value < node.val ? node.left : node.right;
        }

        return node;
    }
}
