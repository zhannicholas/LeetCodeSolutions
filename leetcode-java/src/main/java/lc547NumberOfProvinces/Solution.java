package lc547NumberOfProvinces;

/*
547. 省份数量
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。



示例 1：


输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
输出：2
示例 2：


输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
输出：3


提示：

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] 为 1 或 0
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */
public class Solution {
    /**
     *  遍历所有城市，对于每个城市来说，如果该城市未被访问过，则从该城市开始深度优先搜索，找出与该城市相连的所有城市，并标记这些城市已经访问过。
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int cities = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[cities];
        for (int city = 0; city < cities; city++) {
            if (!visited[city]) {
                provinces++;
                // 深度优先搜索，标记所有相连的城市
                dfs(isConnected, visited, city, cities);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city, int cities) {
        for (int i = 0; i < cities; i++) {
            // 若相连的城市未被访问过，则访问它
            if (isConnected[city][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i, cities);
            }
        }
    }
}
