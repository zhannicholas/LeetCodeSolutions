package l503NextGreaterElementII;

import java.util.Stack;

/*
503. 下一个更大元素 II
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

示例 1:

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
注意: 输入数组的长度不会超过 10000。
*/
public class Solution {
    /**
     * 爆破成功
     */
    public int[] nextGreaterElements_brutal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean find = false;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    find = true;
                    break;
                }
            }
            if (!find) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        res[i] = nums[j];
                        find = true;
                        break;
                    }
                }
            }
            if (!find) {
                res[i] = -1;
            }
        }

        return res;
    }

    /**
     * 单调栈解法（这里用单调递减栈）
     *
     * 假设我们有一个数组为 [3,2,1,5]，当我们在找数字 3 的下一个更大元素时，其实也把 数字 2 和 1 的下一个更大元素找出来了。
     */
    public int[] nextGreaterElements_monotonic_stack(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] copy = new int[n * 2];
        // 复制原数组，避开循环
        System.arraycopy(nums, 0, copy, 0, n);
        System.arraycopy(nums, 0, copy, n, n);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && copy[stack.peek()] < copy[i]) {
                res[stack.pop()] = copy[i];
            }
            stack.push(i % n);
        }

        return res;
    }

    /**
     *  不复制原数组
     */
    public int[] nextGreaterElements_monotonic_stack2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int j = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                res[stack.pop()] = nums[j];
            }
            stack.push(j % n);
        }

        return res;
    }
}
