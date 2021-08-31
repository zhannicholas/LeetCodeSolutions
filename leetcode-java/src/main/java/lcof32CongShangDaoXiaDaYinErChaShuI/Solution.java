package lcof32CongShangDaoXiaDaYinErChaShuI;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]


提示：

节点总数 <= 1000
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize > 0) {
                TreeNode node = queue.poll();
                values.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                qSize--;
            }
        }
        int[] ans = new int[values.size()];
        int i = 0;
        for (Integer value : values) {
            ans[i++] = value;
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
