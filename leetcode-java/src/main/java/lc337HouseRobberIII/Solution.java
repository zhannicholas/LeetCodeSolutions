package lc337HouseRobberIII;

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9
 */
public class Solution {
    public int rob(TreeNode root) {
        long[] profits = postorder(root);
        return (int) Math.max(profits[0], profits[1]);
    }

    /**
     *  后续遍历 + 动态规划
     */
    private long[] postorder(TreeNode root) {
        if (root == null) {
            return new long[]{0, 0};
        }
        long[] l = postorder(root.left);    // 处理左子树得到的结果
        long[] r = postorder(root.right);   // 处理右子树得到的结果
        long rob = root.val + l[1] + r[1];  //  抢了根节点就不能抢左右子节点
        long skip = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);    // 不抢根节点，子节点取最大值和
        return new long[]{rob, skip};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
