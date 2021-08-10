package lc42TrappingRainWater;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：

n == height.length
0 <= n <= 3 * 10^4
0 <= height[i] <= 10^5
 */
public class Solution {
    /**
     * 我们用 left[i]、right[i] 分别表示 height[i] 左右两侧比 height[i] 高的最高的柱子
     * 对于 height[i] 而言，它能接的雨水的量为：min(left[i], right[i]) - height[i]。
     *
     * 以下实现会超时
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n], right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = height[i];
            for (int j = i - 1; j >= 0; j--) {
                left[i] = Math.max(left[i], height[j]);
            }
            right[i] = height[i];
            for (int j = i + 1; j < n; j++) {
                right[i] = Math.max(right[i], height[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    /**
     * trap2 是对 trap1 的优化，虽然 AC，但是耗时依然可观
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftHighest = height[i];
            for (int j = i - 1; j >= 0; j--) {
                leftHighest = Math.max(leftHighest, height[j]);
            }
            int rightHighest = height[i];
            for (int j = i + 1; j < n; j++) {
                rightHighest = Math.max(rightHighest, height[j]);
            }
            ans += Math.min(leftHighest, rightHighest) - height[i];
        }
        return ans;
    }
}
