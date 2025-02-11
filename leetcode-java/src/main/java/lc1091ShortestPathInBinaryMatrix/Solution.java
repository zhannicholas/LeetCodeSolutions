package lc1091ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

/*
1091. 二进制矩阵中的最短路径
给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。

二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：

路径途经的所有单元格都的值都是 0 。
路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
畅通路径的长度 是该路径途经的单元格总数。



示例 1：


输入：grid = [[0,1],[1,0]]
输出：2
示例 2：


输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
输出：4
示例 3：

输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
输出：-1


提示：

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] 为 0 或 1
 */
public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = new int[][] {{-1, 0},{0, 1}, {1, 0}, {0, -1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length;
        // 起点或终点是墙壁
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int qSize = queue.size();
            // 逐层访问
            while (qSize > 0) {
                int[] cord = queue.poll();
                if (cord[0] == n - 1 && cord[1] == n - 1) {
                    return steps;
                }
                for (int[] direction : directions) {
                    int nr = cord[0] + direction[0], nc = cord[1] + direction[1];
                    if ((0 <= nr && nr < n) && (0 <= nc && nc < n) && grid[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 1; // 已访问过，修改为墙，防止再次访问
                    }
                }
                qSize--;
            }
        }
        return -1;
    }
}
