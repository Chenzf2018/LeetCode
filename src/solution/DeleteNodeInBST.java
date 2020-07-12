package solution;

/**
 * leetcode_450_删除二叉搜索树中的节点
 * @author Chenzf
 * @date 2020/7/12
 * @version 1.0
 */

public class DeleteNodeInBST {

    /**
     * 寻找当前节点的后继节点
     * One step right and then always left
     * @param node
     * @return
     */
    public int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    /**
     * 寻找当前节点的前驱节点
     * One step left and then always right
     * @param node
     * @return
     */
    public int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    /**
     * 删除一个节点
     * @param node
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key > node.val) {
            // delete from the right subtree
            node.right = deleteNode(node.right, key);
        } else if (key < node.val) {
            // delete from the left subtree
            node.left = deleteNode(node.left, key);
        } else {
            // delete the current node

            // the node is a leaf
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.right != null) {
                // the node is not a leaf and has a right child
                node.val = successor(node);
                node.right = deleteNode(node.right, node.val);
            } else {
                // the node is not a leaf, has no right child, and has a left child
                node.val = predecessor(node);
                node.left = deleteNode(node.left, node.val);
            }
        }

        return node;
    }
}
