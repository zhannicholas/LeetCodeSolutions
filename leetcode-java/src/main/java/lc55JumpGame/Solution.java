package lc55JumpGame;

/*
55. 跳跃游戏
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。



示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


提示：

1 <= nums.length <= 3 * 10^4
0 <= nums[i] <= 10^5
 */
public class Solution {
    /**
     * 当青蛙站在位置 i 时，它可以活动的范围是 [i, i+A[i]]。原问题转化为，是否可以找到一系列的区间，这些区间能完全覆盖[0, nums.length-1]
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int rightmost = nums[0];
        for (int i = 1; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= n - 1) {
                // 已经可以到达终点了
                return true;
            }
            // 若更新后的右边界都过不了当前位置，那么肯定无法到达终点
            if (rightmost <= i) {
                return false;
            }
        }

        return true;
    }
}
