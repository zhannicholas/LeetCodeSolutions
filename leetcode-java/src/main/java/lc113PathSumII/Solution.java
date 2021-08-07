package lc113PathSumII;

import java.util.ArrayList;
import java.util.List;

/*
113. 路径总和 II
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。



示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：

输入：root = [1,2], targetSum = 0
输出：[]


提示：

树中节点总数在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class Solution {
    /**
     * 对二叉树进行前序遍历+回溯
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        backtrace(root, paths, new ArrayList<>(), 0, targetSum);
        return paths;
    }

    private void backtrace(TreeNode root, List<List<Integer>> paths, List<Integer> path, int sum, int target) {
        if (root == null) {
            return;
        }
        // 将当前节点加入路径
        sum += root.val;
        path.add(root.val);
        // 抵达叶子节点并且路径和等于目标值
        if (root.left == null && root.right == null && sum == target) {
            paths.add(new ArrayList<>(path));
        }
        // 递归左右子节点
        backtrace(root.left, paths, path, sum, target);
        backtrace(root.right, paths, path, sum, target);

        // 当前节点已经使用完，从路径中移除
        path.remove(path.size() - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
