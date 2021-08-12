package lc51NQueens;

import java.util.*;

/*
51. N 皇后
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



示例 1：


输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：[["Q"]]


提示：

1 <= n <= 9
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class Solution {
    /**
     *  由于棋盘为 nxn 且皇后有 n 个，所以必定是一行一个皇后。
     *  开辟一个数组 queens，queens[i] 表示第 i 行放置的皇后所在的列。当找到一个满足条件的数组时，就将其转化为答案要求的列表。
     *  由于我们是一行放置一个皇后，所以我们需要解决列和两个对角线上的冲突，这里用集合处理
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n >= 1) {
            Set<Integer> usedCols = new HashSet<>(n);   // 列
            Set<Integer> dig1 = new HashSet<>(n);   // 对角线，左上到右下，行减列差相等
            Set<Integer> dig2 = new HashSet<>(n);   // 对角线，左下到右上，行加列和相等
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            backtrace(n, 0, queens, usedCols, dig1, dig2, solutions);
        }
        return solutions;
    }

    private void backtrace(int n, int row, int[] queens, Set<Integer> usedCols, Set<Integer> dig1, Set<Integer> dig2, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(generateBoard(queens));
            return;
        }
        // 尝试当前行的所有列位置
        for (int col = 0; col < n; col++) {
            // 找到一个不冲突的位置并放置皇后
            if (!usedCols.contains(col) && !dig1.contains(row - col) && !dig2.contains(row + col)) {
                usedCols.add(col);
                dig1.add(row - col);
                dig2.add(row + col);
                queens[row] = col;
                // 处理下一行
                backtrace(n, row + 1, queens, usedCols, dig1, dig2, solutions);
                usedCols.remove(col);
                dig1.remove(row - col);
                dig2.remove(row + col);
                queens[row] = -1;
            }
        }
    }

    private List<String> generateBoard(int[] queens) {
        List<String> solution = new ArrayList<>();
        for (int q: queens) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int i = q + 1; i < queens.length; i++) {
                sb.append('.');
            }
            solution.add(sb.toString());
        }
        return solution;
    }
}
