package lc169MajorityElement;

import java.util.HashMap;
import java.util.Map;

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
public class Solution {
    /**
     * 排序就不说了，这里用计数
     */
    public int majorityElement(int[] nums) {
        int m = nums.length >> 1;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            int count = counter.getOrDefault(num, 0);
            count++;
            if (count > m) {
                return num;
            }
            counter.put(num, count);
        }
        return -1;
    }
}
