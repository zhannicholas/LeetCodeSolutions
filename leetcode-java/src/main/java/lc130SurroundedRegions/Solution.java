package lc130SurroundedRegions;

/*
130. 被围绕的区域
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。


示例 1：


输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
示例 2：

输入：board = [["X"]]
输出：[["X"]]


提示：

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] 为 'X' 或 'O'
 */
public class Solution {
    private int[][] directions = new int[][]{
            {-1, 0},    // 左
            {0, 1}, // 上
            {1, 0}, // 右
            {0, -1},    // 下
    };

    /**
     * 先找到所有与边界上的 'O' 连通的所有 'O'，将其标记为 'R'。所有剩下的未标记的 'O' 就是被 'X' 包围的，在第二次遍历时修改这些 'O' 为 'X' 并
     * 把 'R' 改回 'O' 即可。
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        // 修改与边界上的 'O' 连通的 'O' 为 'R'
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 1; i < board.length - 1; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        // 修改 'O' 为 'X' 并把 'R' 改回 'O'
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'R') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    /**
     *  以 board[r][c] 为起点，修改 'O' 为 'R'
     */
    private void dfs(char[][] board, int r, int c) {
        if (board[r][c] == 'O') {
            board[r][c] = 'R';
            for (int[] direction: directions) {
                int nr = r + direction[0], nc = c + direction[1];
                // 位置合法且未访问过
                if ((0 <= nr && nr < board.length) && (0 <= nc && nc < board[0].length)) {
                    dfs(board, nr, nc);
                }
            }
        }
    }
}
