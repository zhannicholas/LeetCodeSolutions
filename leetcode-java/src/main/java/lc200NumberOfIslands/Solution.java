package lc200NumberOfIslands;

/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。



示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
 */
public class Solution {
    private int[][] directions = new int[][]{
            {-1, 0},    // 左
            {0, 1}, // 上
            {1, 0}, // 右
            {0, -1},    // 下
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    fill(grid, r, c);
                }
            }
        }
        return ans;
    }

    private void fill(char[][] grid, int r, int c) {
        if (grid[r][c] == '1') {
            grid[r][c] = '-';   // 标记已访问
            for (int[] direction: directions) {
                int nr = r + direction[0], nc = c + direction[1];
                // 若位置合法，则尝试进行标记
                if ((0 <= nr && nr < grid.length) && (0 <= nc && nc < grid[0].length)) {
                    fill(grid, nr, nc);
                }
            }
        }
    }
}
