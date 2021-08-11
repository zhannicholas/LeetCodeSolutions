package lc918MaximumSumCircularSubarray;

/*
918. 环形子数组的最大和
给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。

在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）

此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）



示例 1：

输入：[1,-2,3,-2]
输出：3
解释：从子数组 [3] 得到最大和 3
示例 2：

输入：[5,-3,5]
输出：10
解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
示例 3：

输入：[3,-1,2,-1]
输出：4
解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
示例 4：

输入：[3,-2,2,-3]
输出：3
解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
示例 5：

输入：[-2,-3,-1]
输出：-1
解释：从子数组 [-1] 得到最大和 -1


提示：

-30000 <= A[i] <= 30000
1 <= A.length <= 30000
 */
public class Solution {
    /**
     * 在循环数组中，答案可能有两种情况：
     *  1. 最大子数组和位于 [0,n-1] 这个范围中，此时求解方法同第53题
     *  2. 最大子数组和由 [i,n-1] 和 [0,j] 两部分共同组成，i > j。此时，nums[0] 和 nums[n-1] 肯定在结果数组中，并且有一段子数组做了负面贡献。
     *      我们只需要找到 [1,n-2] 范围内最小的子数组和，它就是最大的负面贡献，然后用整个数组和减去这个最小的和就能得到答案
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int tempMaxSum = nums[0];
        int sum = nums[0];
        int minSum = 0;
        int tempMinSum = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            tempMaxSum = Math.max(tempMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, tempMaxSum);
            sum += nums[i];
            tempMinSum = Math.min(tempMinSum + nums[i], nums[i]);
            minSum = Math.min(minSum, tempMinSum);
        }

        tempMaxSum = Math.max(tempMaxSum + nums[nums.length - 1], nums[nums.length - 1]);
        maxSum = Math.max(maxSum, tempMaxSum);
        sum += nums[nums.length - 1];

        return Math.max(maxSum, sum - minSum);
    }

    /**
     * 以下解法由于时间复杂度是 O(n^2)，超时未通过
     */
    public int maxSubarraySumCircular_timeout(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = maxSubArray(nums, 0);
        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(maxSum, maxSubArray(nums, i));
        }
        return maxSum;
    }

    /**
     * See: Leetcode 53
     */
    private int maxSubArray(int[] nums, int start) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[start];
        int tempMaxSum = nums[start];   // 表示以上一个数组元素为结尾的最大子数组和
        for (int i = start + 1; i < nums.length; i++) {
            // 若之前的子数组和对现在元素有帮助，则纳入，否则抛弃
            tempMaxSum = Math.max(tempMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, tempMaxSum);
        }
        for (int i = 0; i < start; i++) {
            // 若之前的子数组和对现在元素有帮助，则纳入，否则抛弃
            tempMaxSum = Math.max(tempMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, tempMaxSum);
        }

        return maxSum;
    }
}
