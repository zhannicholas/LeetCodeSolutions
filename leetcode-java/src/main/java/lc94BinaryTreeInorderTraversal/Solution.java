package lc94BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回它的 中序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {
    /**
     * 迭代
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 深入左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 左子树到头，弹栈
            root = stack.pop();
            inorder.add(root.val);
            // 转向右子树
            root = root.right;
        }
        return inorder;
    }

    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(inorder, root);
        return inorder;
    }

    private void inorderTraversal(List<Integer> inorder, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(inorder, root.left);
        inorder.add(root.val);
        inorderTraversal(inorder, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
