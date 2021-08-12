package lc120Triangle;

import java.util.List;

/*
120. 三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。



示例 1：

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：

输入：triangle = [[-10]]
输出：-10


提示：

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104


进阶：

你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class Solution {
    /**
     * 动态规划：开辟一个大小为 n 的数组 dp，dp[i] 表示当前层以第 i 个元素结尾的最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            // 第一个和最后一个需要特殊处理一下
            int t1 = dp[0];  // 临时保存上一层的值，防止更新数组时将其覆盖
            dp[0] += row.get(0);
            int k = row.size();
            for (int j = 1; j < k - 1; j++) {
                int t2 = dp[j];
                dp[j] = Math.min(t1, dp[j]) + row.get(j);
                t1 = t2;

            }
            dp[k - 1] = t1 + row.get(k - 1);
        }

        int min = dp[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
