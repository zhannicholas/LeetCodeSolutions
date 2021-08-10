package lc56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
56. 合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。



示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


提示：

1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 按区间起点排序
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<Interval> ansList = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                // 重叠区间合并完成
                ansList.add(new Interval(start, end));
                // 更新下一个合并区间的范围
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }

        int[][] ans = new int[ansList.size() + 1][2];
        for (int i = 0; i < ansList.size(); i++) {
            Interval interval = ansList.get(i);
            ans[i] = new int[]{interval.start, interval.end};
        }
        ans[ansList.size()] = new int[]{start, end};
        return ans;
    }
}

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
