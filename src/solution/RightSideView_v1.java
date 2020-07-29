package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_199_二叉树的右视图
 * @author Chenzf
 * @date 2020/7/29
 * @version 1.0 深度优先
 */

public class RightSideView_v1 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // 从根节点开始访问，根节点深度是0
        deepFirstSearch(root, 0);
        return result;
    }

    private void deepFirstSearch(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // 先访问当前节点，再递归地访问右子树和左子树
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点
        // 因此将当前节点加入res中
        if (depth == result.size()) {
            result.add(node.val);
        }

        depth++;
        deepFirstSearch(node.right, depth);
        deepFirstSearch(node.left, depth);
    }
}
