package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_144_二叉树的前序遍历
 * @author Chenzf
 * @date 2020/7/26
 * @version 1.0 递归法
 */

public class PreorderTraversal_v1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
