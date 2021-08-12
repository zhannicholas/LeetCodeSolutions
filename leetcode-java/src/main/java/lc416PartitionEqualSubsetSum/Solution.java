package lc416PartitionEqualSubsetSum;

/*
416. 分割等和子集
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。


提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
public class Solution {
    /**
     *  假设整个数组的和为 sum，则原问题等价为：能够从数组中找到一个和为 sum/2 的子集。由于数组的每个元素都是整数，所以 sum 应该为偶数。
     *  此外，数组中也不应该有大于 sum/2 的元素。
     *  采用动态规划求解，开辟一个大小为 sum/2 的数组 dp，dp[i] 表示能否从数组 nums 中找出一个和为 i 的子集，则：
     *  if (num in nums) then dp[num] = true
     *  if ((dp[num] = true) && (i-num in nums)) then dp[i] = true
     */
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int num: nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 0x01) == 1) {
            // 数组和为奇数
            return false;
        }
        int target = sum >> 1;
        if (maxNum > target) {
            // 数组中有一个元素大于数组和的一半
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i > 0; i--) {
                if (i >= num) {
                    dp[i] |= dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
