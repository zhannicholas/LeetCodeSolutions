package lc52NQueenII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
52. N皇后 II
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。



示例 1：


输入：n = 4
输出：2
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：1


提示：

1 <= n <= 9
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class Solution {
    private int solutions = 0;
    /**
     * See: Leetcode 51 (https://leetcode-cn.com/problems/n-queens/)
     */
    public int totalNQueens(int n) {
        if (n >= 1) {
            Set<Integer> usedCols = new HashSet<>(n);   // 列
            Set<Integer> dig1 = new HashSet<>(n);   // 对角线，左上到右下，行减列差相等
            Set<Integer> dig2 = new HashSet<>(n);   // 对角线，左下到右上，行加列和相等
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            backtrace(n, 0, queens, usedCols, dig1, dig2);
        }
        return solutions;
    }

    private void backtrace(int n, int row, int[] queens, Set<Integer> usedCols, Set<Integer> dig1, Set<Integer> dig2) {
        if (row == n) {
            solutions++;
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
                backtrace(n, row + 1, queens, usedCols, dig1, dig2);
                usedCols.remove(col);
                dig1.remove(row - col);
                dig2.remove(row + col);
                queens[row] = -1;
            }
        }
    }
}
