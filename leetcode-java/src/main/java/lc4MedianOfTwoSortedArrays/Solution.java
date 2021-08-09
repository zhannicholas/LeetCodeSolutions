package lc4MedianOfTwoSortedArrays;

/*
4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000


提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6


进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class Solution {
    /**
     *  考虑 nums1.length + nums2.length 的奇偶性，用 sorted (sorted.length = s) 表示对 nums1 和 nums2 排序合并后的数组：
     *  1. 若为偶数，则中位数为排序后数组的中间两个数的平均值，即：(sorted[s / 2 - 1] + sorted[s / 2]) / 2
     *  2. 若为奇数，则中位数为排序后数组的中间数字，即 sorted[s / 2]
     *  实际上，我们并不需要对 nums1 和 nums2 进行排序，因为二者各自有序。我们只需要从前往后迭代，丢弃掉对应数量的数字，找到位于中间的数字即可
     *  例如：nums1 = {1,2}，nums2 = {2,3}，需要丢弃一个数字，然后取剩下两个最小数的平均值
     *       nums1 = {1}，nums2 = {2,4}，需要丢弃一个数字，然后取剩下最小的数字
     *  总的来说，当 s 是偶数时，丢弃掉 s/2-1 个数字；当 s 是奇数时，丢弃掉 s/2 个数字
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int s = m + n;
        int i = 0, j = 0;
        int numsToDiscard = s % 2 == 0 ? s / 2 - 1 : s / 2;
        while (numsToDiscard > 0) {
            if (i < m && j < n) {
                // nums1 与 nums2 都还未遍历的元素
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i >= m) {
                // nums1 已遍历完，只剩 nums2
                j++;
            } else {
                // nums2 已遍历完，只剩 nums1
                i++;
            }
            numsToDiscard--;
        }

        // min1 和 min2 分别表示 nums1[i..m-1] 与 nums2[j..n-1] 中的最小的数和倒数第二小的数
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        if (i < m && j < n) {
            min1 = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        } else if (i >= m) {
            min1 = nums2[j++];
        } else {
            min1 = nums1[i++];
        }
        if (s % 2 == 1) {
            return min1;
        }
        if (i < m && j < n) {
            min2 = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
        } else if (i >= m) {
            min2 = nums2[j];
        } else {
            min2 = nums1[i];
        }
        return (min1 + min2) / 2.0;
    }
}
