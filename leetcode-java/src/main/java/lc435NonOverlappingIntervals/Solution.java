package lc435NonOverlappingIntervals;

import java.util.Arrays;

/*
435. 无重叠区间
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Solution {
    /**
     * 原问题可以转化为：找不重叠区间的最大数量
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;
        // 先对区间按照右边界排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int nonOverlapIntervals = 0;    // 不重叠区间个数
        int maxEnd = Integer.MIN_VALUE; // 已遍历过的不重叠区间的最右边界
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= maxEnd) {
                maxEnd = intervals[i][1];
                nonOverlapIntervals++;
            }
        }

        return n - nonOverlapIntervals;
    }
}
