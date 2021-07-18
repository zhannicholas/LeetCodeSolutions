package lc977SquaresOfASortedArray;

/*
977. 有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。



示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]


提示：

1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums 已按 非递减顺序 排序


进阶：

请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class Solution {
    /**
     * 使用 ne 和 po 两个指针分别指向负数的最大值和正数的最小值，然后选取绝对值较小的那个数进行平方运算。
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        if (nums[0] >= 0) {
            for (int i = 0; i < n; i++) {
                squares[i] = nums[i] * nums[i];
            }
        } else if (nums[n - 1] <= 0) {
            for (int i = 0; i < n; i++) {
                squares[i] = nums[n - 1 - i] * nums[n - 1 - i];
            }
        } else {
            int l = 0, r = n - 1;
            int ne = 0, po;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[m] > 0) {
                    r = m - 1;
                    ne = m - 1;
                } else if (nums[m] < 0) {
                    l = m + 1;
                    ne = m;
                } else {
                    ne = m - 1;
                    break;
                }
            }
            po = ne + 1;
            int i = 0;
            while (ne >= 0 && po < n) {
                if (-nums[ne] < nums[po]) {
                    squares[i++] = nums[ne] * nums[ne];
                    ne--;
                } else {
                    squares[i++] = nums[po] * nums[po];
                    po++;
                }
            }
            while (ne >= 0) {
                squares[i++] = nums[ne] * nums[ne];
                ne--;
            }
            while (po < n) {
                squares[i++] = nums[po] * nums[po];
                po++;
            }
        }

        return squares;
    }
}
