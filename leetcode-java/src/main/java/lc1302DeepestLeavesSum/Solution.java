package lc1302DeepestLeavesSum;

import java.util.LinkedList;
import java.util.Queue;

/*
1302. 层数最深叶子节点的和
给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。



示例 1：



输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
示例 2：

输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：19


提示：

树中节点数目在范围 [1, 10^4] 之间。
1 <= Node.val <= 100
 */
public class Solution {
    /**
     * 层次遍历，最后一层的节点和就是答案
     */
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            sum = 0;
            while (qSize > 0) {
                TreeNode node = queue.poll();
                qSize--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
        }

        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
