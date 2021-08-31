package lcof32CongShangDaoXiaDaYinErChaShuIII;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]


提示：

节点总数 <= 1000
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            while (qSize > 0) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                qSize--;
            }
            if (reverse) {
                Collections.reverse(curLevel);
            }
            ans.add(curLevel);
            reverse = !reverse;
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
