package lc543DiameterOfBinaryTree;

/*
543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。



示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。



注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Solution {
    private int maxNodeCnt = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxNodeCnt - 1;
    }

    /**
     * 求二叉树的最大深度，从根节点到最深叶子节点的边的数目就是最大深度减1
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        maxNodeCnt = Math.max(maxNodeCnt, l + r + 1);
        return Math.max(l, r) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
