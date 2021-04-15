package lc213HouseRobberII;

/*
213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class Solution {
    /**
     * 由于第一家与最后一家相邻，形成了一个环。所以我们要么打劫 num[0..n-2] 范围内的，要么打劫 nums[1..n-1] 范围内的。
     * 问题转化为打家劫舍。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) { // 必须要打劫
            return nums[0];
        }
        int n = nums.length;
        int profit1 = nums[0], profit2 = Math.max(profit1, nums[1]);
        if (n == 2) {
            return Math.max(profit1, profit2);
        }
        for (int i = 2; i < n - 1; i++) {
            int t = Math.max(profit1 + nums[i], profit2);
            profit1 = Math.max(profit1, profit2);
            profit2 = t;
        }

        int temp = Math.max(profit1, profit2);

        profit1 = nums[1];
        profit2 = Math.max(profit1, nums[2]);
        for (int i = 3; i < n; i++) {
            int t = Math.max(profit1 + nums[i], profit2);
            profit1 = Math.max(profit1, profit2);
            profit2 = t;
        }

        return Math.max(temp, Math.max(profit1, profit2));
    }
}
