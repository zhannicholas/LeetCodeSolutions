package lcof26ShuDeZiJieGou;

import java.util.Stack;

/*
剑指 Offer 26. 树的子结构
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：

输入：A = [3,4,5,1,2], B = [4,1]
输出：true
限制：

0 <= 节点个数 <= 10000
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (A != null || !stack.isEmpty()) {
            // 深入迭代左子树
            while (A != null) {
                if (subStructure(A, B)) {
                    return true;
                }
                stack.push(A);
                A = A.left;
            }
            // 迭代右子树
            A = stack.pop();
            A = A.right;
        }
        return false;
    }

    private boolean subStructure(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return true;
        }
        return root1.val == root2.val && subStructure(root1.left, root2.left) && subStructure(root1.right, root2.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
