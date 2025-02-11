package lc787CheapestFlightsWithinKStops;

import java.util.*;

/*
787. K 站中转内最便宜的航班
有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。

现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。



示例 1：

输入:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
输出: 200
解释:
城市航班图如下


从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
示例 2：

输入:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
输出: 500
解释:
城市航班图如下


从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。


提示：

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 10^4
航班没有重复，且不存在自环
0 <= src, dst, k < n
src != dst
 */
public class Solution {
    private int cheapestPrice = Integer.MAX_VALUE;

    /**
     * 动态规划。使用 dp[i][to] 表示经过 i 次飞行到达 to 的最小花费，则 dp[i][to] = min{dp[i-1][from] + price[from][to]}
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 101 * 10000 + 1;
        int cheapestPrice = INF;
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;
        for (int i = 1; i < k + 2; i++) {
            for (int[] flight: flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + price);
            }
        }

        for (int i = 0; i < k + 2; i++) {
            cheapestPrice = Math.min(cheapestPrice, dp[i][dst]);
        }

        return cheapestPrice == INF ? -1 : cheapestPrice;
    }

    /**
     *  邻接链表超时
     */
    public int findCheapestPrice_timeout2(int n, int[][] flights, int src, int dst, int k) {
        cheapestPrice = Integer.MAX_VALUE;
        // 先建立邻接链表
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] flight: flights) {
            List<int[]> adjList = adjMap.get(flight[0]);
            if (adjList == null) {
                adjList = new ArrayList<>();
            }
            adjList.add(new int[]{flight[1], flight[2]});
            adjMap.put(flight[0], adjList);
        }
        dfs(adjMap, src, dst, 0, k);
        return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
    }

    private void dfs(Map<Integer, List<int[]>> adjMap, int src, int dst, int price, int k) {
        if (src == dst) {
            cheapestPrice = Math.min(cheapestPrice, price);
            return;
        }
        if (k < 0 || !adjMap.containsKey(src)) {
            return;
        }

        for (int[] dstPrice: adjMap.get(src)) {
            if (price + dstPrice[1] < cheapestPrice) {
                price += dstPrice[1];
                dfs(adjMap, dstPrice[0], dst, price, --k);
                k++;
                price -= dstPrice[1];
            }
        }
    }

    /**
     * 邻接矩阵超时
     */
    public int findCheapestPrice_timeout(int n, int[][] flights, int src, int dst, int k) {
        cheapestPrice = Integer.MAX_VALUE;
        // 先建立邻接矩阵
        int[][] matrix = new int[n][n];
        for (int[] flight: flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }
        dfs(matrix, src, dst, 0, k);
        return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
    }

    private void dfs(int[][] matrix, int src, int dst, int price, int k) {
        if (src == dst) {
            cheapestPrice = Math.min(cheapestPrice, price);
            return;
        }
        if (k < 0) {
            return;
        }
        for (int j = 0; j < matrix[0].length;j++) {
            // 需要剪枝，防止 OOM
            if (matrix[src][j] != 0 && price + matrix[src][j] < cheapestPrice) {
                price += matrix[src][j];
                dfs(matrix, j, dst, price, --k);
                price -= matrix[src][j];
                k++;
            }
        }
    }
}
