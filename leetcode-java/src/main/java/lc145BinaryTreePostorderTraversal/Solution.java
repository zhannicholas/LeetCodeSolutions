package lc145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {
    /**
     * 迭代
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;    // 上一个遍历过的节点
        while (root != null || !stack.isEmpty()) {
            // 深入左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            // 若当前节点的右子树为空或右子树已经遍历过，则可以将当前节点的值加入到结果中
            if (root.right == null || root.right == pre) {
                postorder.add(root.val);
                stack.pop();
                pre = root;
                // 已经遍历过的节点要置空，否则下一轮还会被遍历
                root = null;
            } else {
                // 第一次到的节点要先遍历右子树
                root = root.right;
            }
        }
        return postorder;
    }

    /**
     * 递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(postorder, root);
        return postorder;
    }

    private void postorderTraversal(List<Integer> postorder, TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(postorder, root.left);
        postorderTraversal(postorder, root.right);
        postorder.add(root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
