package lc450DeleteNodeInABst;

/*
450. 删除二叉搜索树中的节点
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 空树不进行任何操作
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // 被删除的节点在左子树中
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 被删除的节点在右子树中
            root.right = deleteNode (root.right, key);
        } else {
            // 被删除的节点是根节点
            if (root.left == null && root.right == null) {
                // 根节点无子节点
                return null;
            } else if (root.left != null) {
                // 根节点有左子树，从左子树中选择最大的那个节点替换掉根节点
                TreeNode largest = root.left;
                while (largest.right != null) {
                    largest = largest.right;
                }
                swapNode(largest, root);
                root.left = deleteNode(root.left, key);
            } else if (root.right != null) {
                // 根节点有右子树，从右子树中选择最小的节点替换掉根节点
                TreeNode smallest = root.right;
                while (smallest.left != null) {
                    smallest = smallest.left;
                }
                swapNode(smallest, root);
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    private void swapNode(TreeNode n1, TreeNode n2) {
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}