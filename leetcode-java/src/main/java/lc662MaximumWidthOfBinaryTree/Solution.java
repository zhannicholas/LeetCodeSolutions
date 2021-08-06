package lc662MaximumWidthOfBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/*
662. 二叉树最大宽度
给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入:

           1
         /   \
        3     2
       / \     \
      5   3     9

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:

输入:

          1
         /
        3
       / \
      5   3

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
示例 3:

输入:

          1
         / \
        3   2
       /
      5

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
示例 4:

输入:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
注意: 答案在32位有符号整数的表示范围内。
 */
public class Solution {
    /**
     *  对满二叉树进行层次遍历时保留空节点，使用双端队列。假设节点 node 在当前层的位置为 node.position = p (0-based)，则：
     *  node.left.position = 2 * p, node.right.position = 2 * p + 1
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Deque<PositionedNode> dq = new LinkedList<>();
        if (root != null) {
            dq.offer(new PositionedNode(root, 0));
        }
        while (!dq.isEmpty()) {
            int qSize = dq.size();
            // 去除左右两侧的空节点
            while (!dq.isEmpty() && dq.peekFirst().node == null) {
                dq.pollFirst();
                qSize--;
            }
            while (!dq.isEmpty() && dq.peekLast().node == null) {
                dq.pollLast();
                qSize--;
            }
            // 计算宽度
            if (qSize <= 0) {
                return maxWidth;
            }
            maxWidth = Math.max(maxWidth, dq.peekLast().position - dq.peekFirst().position + 1);
            // 下一层节点入队
            while (qSize > 0) {
                PositionedNode node = dq.pollFirst();
                if (node != null && node.node != null) {
                    dq.offerLast(new PositionedNode(node.node.left, node.position * 2));
                    dq.offerLast(new PositionedNode(node.node.right, node.position * 2 + 1));
                }
                qSize--;
            }
        }
        return maxWidth;
    }
}

class PositionedNode {
    TreeNode node;
    int position;

    public PositionedNode(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {this.val = val;}
}
