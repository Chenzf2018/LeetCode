package solution;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * leetcode_102_二叉树的层序遍历
 */

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode node) {
        // 最后输出结果
        List<List<Integer>> result = new ArrayList<>();
        // 存放每层的结点
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);

        while (! queue.isEmpty()) {
            int size = queue.size();

            // 每一层的遍历结果
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                // queue.peek()返回队列的头元素，不删除
                TreeNode currentNode = queue.peek();
                /*
                Queue中remove()和poll()都是用来从队列头部删除一个元素。
                在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，
                poll() 方法只会返回null
                 */
                queue.poll();

                // 防止当结点的左结点为null，右结点不为null时，出现queue=[null, XX]
                if (currentNode == null) {
                    continue;
                }

                level.add(currentNode.val);

                // 利用完当前结点后，将其左、右结点加入队列中
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }

            if (! level.isEmpty()) {
                // 将每一层的结果加入最终结果列表中
                result.add(level);
            }
        }

        return result;
    }
}
