package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode_199_二叉树的右视图
 * @author Chenzf
 * @date 2020/7/29
 * @version 2.0 广度优先
 */

public class RightSideView_v2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()) {
            // 当前层节点个数
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 将node的子树推入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                // 将当前层的最后一个节点放入结果列表
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }

}
