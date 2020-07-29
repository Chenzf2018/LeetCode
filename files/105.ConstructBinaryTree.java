package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode_105_从前序与后序遍历序列构造二叉树
 * @author Chenzf
 * @date 2020/7/29
 * @version 1.0 递归
 */

public class ConstructBinaryTree {
    // 便于在中序遍历中对根节点进行定位
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int numberOfNode = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < numberOfNode; i++) {
            indexMap.put(inorder[i], i);
        }

        return constructBinaryTree(preorder, inorder,
                0, numberOfNode - 1,
                0, numberOfNode - 1);
    }

    public TreeNode constructBinaryTree(int[] preorder, int[] inorder,
                                        int preorderLeft, int preorderRight,
                                        int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorderRootIndex = preorderLeft;
        // 在中序遍历中定位根节点
        int inorderRootIndex = indexMap.get(preorder[preorderRootIndex]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderRootIndex]);

        // 得到左子树中的节点数目
        int sizeOfLeftSubtree = inorderRootIndex - inorderLeft;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素
        // 对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = constructBinaryTree(preorder, inorder,
                preorderLeft + 1, preorderLeft + sizeOfLeftSubtree,
                inorderLeft, inorderRootIndex - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素
        // 对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = constructBinaryTree(preorder, inorder,
                preorderLeft + sizeOfLeftSubtree + 1, preorderRight,
                inorderRootIndex + 1, inorderRight);

        return root;
    }
}
