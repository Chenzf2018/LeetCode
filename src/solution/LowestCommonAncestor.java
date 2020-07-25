package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode_236_二叉树的最近公共祖先
 * @author Chenzf
 * @date 2020/7/25
 * @version 1.0 用哈希表存储所有节点的父节点
 */

public class LowestCommonAncestor {
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针
        deepFirstSearch(root);

        // 从p节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点
        while (p != null) {
            visited.add(p.val);
            // 得到p节点所对应的父节点
            p = parent.get(p.val);
        }

        // 再从q节点开始不断往它的祖先移动
        // 如果有祖先已经被访问过，即意味着这是p和q的深度最深的公共祖先
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }

        return null;
    }

    /**
     * 从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针
     */
    public void deepFirstSearch(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            deepFirstSearch(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            deepFirstSearch(root.right);
        }
    }
}
