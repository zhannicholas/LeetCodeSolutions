package lc33SearchInRotatedSortedArray;

/*
33. 搜索旋转排序数组
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。



示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1


提示：

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4


进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */
public class Solution {
    /**
     * 二分查找。
     * 旋转后的数组可以看成左右两部分各自升序排列的两个部分。根据选择点的不同，可以大致分为两种情况：
     * 1. 实际上没有旋转：[0,1,2,3,4,5,6,7] 这种
     * 2. 进行了旋转：[5,6,7,0,1,2,3,4] 这种
     * 对于第 2 种，可以根据 nums[0] 与 nums[m] 的 大小决定出 target 位于哪一部分
     * 当 nums[l] <= nums[mid] 时
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            }
            // 左侧有序
            if (nums[0] <= nums[m]) {
                if (nums[0] <= target && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {    // 右侧有序
                if (nums[m] <= target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
