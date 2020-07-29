package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode_94_二叉树的中序遍历
 * @author Chenzf
 * @date 2020/7/26
 * @version 2.0 迭代法
 */

public class InorderTraversal_v2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || ! stack.isEmpty()) {
            // 先将根节点cur和所有的左孩子入栈并加入结果中，直至cur为空
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 每弹出一个栈顶元素，就到达它的右孩子
            // 再将这个节点当作 cur 重新按上面的步骤来一遍，直至栈为空
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}
