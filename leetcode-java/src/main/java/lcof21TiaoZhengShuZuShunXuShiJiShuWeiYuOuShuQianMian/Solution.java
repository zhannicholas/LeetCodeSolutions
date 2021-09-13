package lcof21TiaoZhengShuZuShunXuShiJiShuWeiYuOuShuQianMian;

/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。



示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。


提示：

0 <= nums.length <= 50000
1 <= nums[i] <= 10000
 */
public class Solution {
    /**
     * 双指针：even 指针指向偶数，从前往后遍历；odd 指针指向奇数，从后往前遍历
     * 每次交换奇数和偶数，当两个指针相遇时，结束
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int odd = nums.length - 1, even = 0;
        while (even < odd) {
            // 找到偶数
            while (even < odd && (nums[even] & 1) == 1) {
                even++;
            }
            // 找到奇数
            while (odd > even && ((nums[odd] & 1) == 0)) {
                odd--;
            }
            if ((nums[even] & 1) == 0 && (nums[odd] & 1) == 1) {
                int t = nums[odd];
                nums[odd] = nums[even];
                nums[even] = t;
            }
        }
        return nums;
    }
}
