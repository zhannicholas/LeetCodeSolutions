package lc456123Pattern;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
456. 132 模式
给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。

如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。



进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？



示例 1：

输入：nums = [1,2,3,4]
输出：false
解释：序列中不存在 132 模式的子序列。
示例 2：

输入：nums = [3,1,4,2]
输出：true
解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
示例 3：

输入：nums = [-1,3,2,0]
输出：true
解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。


提示：

n == nums.length
1 <= n <= 104
-109 <= nums[i] <= 109
*/
public class Solution {
    /**
     * 单调栈：维护3，找3左边的最小元素作为1，找3右边的最大元素作为2
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(nums[i - 1], leftMin[i - 1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            int numsK = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peek() < nums[j]) {
                numsK = stack.pop();
            }
            if (numsK > leftMin[j]) {
                return true;
            }
            stack.push(nums[j]);
        }

        return false;
    }
}
