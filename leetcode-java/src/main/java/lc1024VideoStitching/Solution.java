package lc1024VideoStitching;

import java.util.Arrays;

/*
1024. 视频拼接
你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。



示例 1：

输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
输出：3
解释：
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
示例 2：

输入：clips = [[0,1],[1,2]], T = 5
输出：-1
解释：
我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
示例 3：

输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
输出：3
解释：
我们选取片段 [0,4], [4,7] 和 [6,9] 。
示例 4：

输入：clips = [[0,4],[2,8]], T = 5
输出：2
解释：
注意，你可能录制超过比赛结束时间的视频。


提示：

1 <= clips.length <= 100
0 <= clips[i][0] <= clips[i][1] <= 100
0 <= T <= 100
 */
public class Solution {
    /**
     * 贪心策略：先根据区间起点对所有区间进行排序，然后在每个区间能覆盖的范围内选择下一个区间的起点，使得下一个区间的终点最远
     */
    public int videoStitching(int[][] clips, int time) {
        if (clips == null || clips.length == 0) {
            return -1;
        }
        int n = clips.length;
        // 按照区间起点升序排列
        Arrays.sort(clips, (c1, c2) -> c1[0] - c2[0] == 0 ? c2[1] - c1[1] : c1[0] - c2[0]);
        // 第一个区间都不满足要求，就不用看后面的了
        if (clips[0][0] > time || clips[0][0] > 0) {
            return -1;
        }
        // 最起码要选择一个区间
        int ans = 1;
        int rightmost = clips[0][1];  // 当前可覆盖的最远位置
        int i = 0;
        while (i < n) {
            if (rightmost >= time) {
                return ans;
            }
            if (clips[i][0] > rightmost) {
                // 区间起点无法与当前可覆盖的最远位置形成交集，直接结束
                return -1;
            }
            ans++;  // 需要选一个区间
            int leftBound = clips[i][0];
            int rightBound = clips[i][1];
            while (i + 1 < n && (clips[i + 1][0] == leftBound || (clips[i + 1][0] >= leftBound && clips[i + 1][1] <= rightBound))) {
                // 区间起点相同，就没必要看了，因为七点相同的区间是按照终点降序排列的
                // 当前区间的子区间也不用看了
                i++;
            }
            int j = i + 1;
            int t = i + 1;
            while (j < n && clips[j][0] <= rightBound) {
                if (rightmost < clips[j][1]) {
                    rightmost = clips[j][1];
                    t = j;
                }
                j++;
            }
            i = t;
        }

        return -1;
    }
}
