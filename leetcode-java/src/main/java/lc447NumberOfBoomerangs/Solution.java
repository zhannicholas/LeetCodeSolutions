package lc447NumberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

/*
447. 回旋镖的数量
给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

返回平面上所有回旋镖的数量。


示例 1：

输入：points = [[0,0],[1,0],[2,0]]
输出：2
解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
示例 2：

输入：points = [[1,1],[2,2],[3,3]]
输出：2
示例 3：

输入：points = [[1,1]]
输出：0


提示：

n == points.length
1 <= n <= 500
points[i].length == 2
-10^4 <= xi, yi <= 10^4
所有点都 互不相同
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] from: points) {
            // 建立查找表，key：距离，value：点的数量
            Map<Integer, Integer> distanceMap = new HashMap<>();
            for (int[] to: points) {
                int dist = distance(from, to);
                if (distanceMap.containsKey(dist)) {
                    distanceMap.put(dist, distanceMap.get(dist) + 1);
                } else {
                    distanceMap.put(dist, 1);
                }
            }
            // 遍历查找表，计算排列数
            for (Map.Entry<Integer, Integer> entry: distanceMap.entrySet()) {
                if (entry.getValue() < 2) {
                    continue;   // 没有有效的点对
                }
                int cnt = entry.getValue();
                ans += permutations(cnt, 2);
            }
        }

        return ans;
    }

    private int distance(int[] p1, int[] p2) {
        int xdiff = p1[0] - p2[0];
        int ydiff = p1[1] - p2[1];
        return xdiff * xdiff + ydiff * ydiff;
    }

    private int permutations(int n, int m) {
        int permutations = n;
        for (int i = n - 1; i >= n - m + 1; i--) {
            permutations *= i;
        }
        return permutations;
    }
}
