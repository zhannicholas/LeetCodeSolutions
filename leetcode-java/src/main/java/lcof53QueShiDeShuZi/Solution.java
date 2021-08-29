package lcof53QueShiDeShuZi;

/*
剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。



示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8
 */
public class Solution {
    /**
     * 利用数组有序的性质进行二分查找。如果不缺失数字，那么 nums[i] = i。从缺失的那个数字开始，nums[i] != i。所以找到这个开始位置即可
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 0 || nums[0] != 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m;
            }
            if (l == r) {
                return nums[l] == l ? l + 1 : l;
            }
        }
        return l;
    }
}
