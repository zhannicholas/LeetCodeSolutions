package lc713SubarrayProductLessThanK;

/*
713. 乘积小于K的子数组
给定一个正整数数组 nums和整数 k 。

请找出该数组内乘积小于 k 的连续的子数组的个数。



示例 1:

输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
示例 2:

输入: nums = [1,2,3], k = 0
输出: 0


提示:

1 <= nums.length <= 3 * 10^4
1 <= nums[i] <= 1000
0 <= k <= 10^6
 */
public class Solution {
    /**
     * 滑动窗口，用左开右闭的区间
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int left = -1;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            // 将数组元素加入子区间
            product *= nums[right];
            // 条件不满足，收紧左边界
            while (product >= k && left < right) {
                product /= nums[++left];
            }
            ans += right - left;
        }

        return ans;
    }
}
