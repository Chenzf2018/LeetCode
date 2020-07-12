package solution;

/**
 * leetcode_700_二叉搜索树中的搜索
 * @author Chenzf
 * @date 2020/7/12
 * @version 1.0 递归
 */

public class SearchInBinarySearchTree_v1 {
    public TreeNode searchBST(TreeNode node, int value) {
        if (node == null || value == node.val) {
            return node;
        }

        return value < node.val ? searchBST(node.left, value) : searchBST(node.right, value);
    }
}
