package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_145_二叉树的后序遍历
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0 递归
 */

public class PostorderTraversal_v1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public void postorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            if (node.left != null) {
                postorderTraversal(node.left, result);
            }
            if (node.right != null) {
                postorderTraversal(node.right,result);
            }
            result.add(node.val);
        }
    }
}
