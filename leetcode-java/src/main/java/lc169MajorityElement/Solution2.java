package lc169MajorityElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1：

输入：[3,2,3]
输出：3
示例 2：

输入：[2,2,1,1,1,2,2]
输出：2


进阶：

尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Solution2 {
    /**
     * 试一下随机算法
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int m = n >> 1;
        Random random = new Random();
        while (true) {
            int idx = random.nextInt(n);
            if (count(nums, nums[idx]) > m) {
                return nums[idx];
            }
        }
    }

    private int count(int[] nums, int num) {
        int cnt = 0;
        for (int n: nums) {
            if (n == num) {
                cnt++;
            }
        }
        return cnt;
    }
}
