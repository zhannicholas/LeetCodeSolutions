package lc236LowestCommonAncestorOfABinaryTree;

/*
236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



示例 1：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
示例 2：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
示例 3：

输入：root = [1,2], p = 1, q = 2
输出：1


提示：

树中节点数目在范围 [2, 10^5] 内。
-10^9 <= Node.val <= 10^9
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。
 */
public class Solution {
    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postorder(root, p, q);
        return lca;
    }

    /**
     * 后序遍历统计根节点为 root 的树中，p 与 q 节点的数量，当节点数量为 2 时，此时的 root 就是最低公共祖先
     */
    private int postorder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int lcnt = postorder(root.left, p, q);
        int rcnt = postorder(root.right, p, q);

        if (lcnt == 1 && rcnt == 1) {
            // 左右刚好一边一个
            lca = root;
        } else if ((lcnt == 1 || rcnt == 1) && (root == p || root == q)) {
            // 左右其中有一个，自己就是另一个
            lca = root;
        }

        return lcnt + rcnt + ((root == p || root == q) ? 1 : 0);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
