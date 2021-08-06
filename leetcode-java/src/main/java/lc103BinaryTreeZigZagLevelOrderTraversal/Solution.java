package lc103BinaryTreeZigZagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class Solution {
    /**
     * 层次遍历 + 条件反转
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (reverse) {
                    curLevel.addFirst(node.val);
                } else {
                    curLevel.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            levelOrder.add(curLevel);
            reverse = !reverse;
        }
        return levelOrder;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
