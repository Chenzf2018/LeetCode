package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_94_二叉树的中序遍历
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0 递归法
 */

public class InorderTraversal_v1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left != null) {
                inorderTraversal(node.left, result);
            }
            result.add(node.val);
            if (node.right != null) {
                inorderTraversal(node.right, result);
            }
        }
    }
}
