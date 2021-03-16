package lc59SpiralMatrixII;

import java.util.ArrayList;
import java.util.List;

/*
59. 螺旋矩阵 II
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。


示例 1：


输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]


提示：

1 <= n <= 20
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int minI = 0, maxI = n - 1;
        int minJ = 0, maxJ = n - 1;
        int i = minI, j = minJ;
        int v = 1;
        while ((minI <= i && i <= maxI) && (minJ <= j && j <= maxJ)) {
            while (j <= maxJ) {
                matrix[i][j++] = v++;
            }
            i++;
            minI++;
            j--;
            if (minI > maxI) {
                break;
            }
            while (i <= maxI) {
                matrix[i++][j] = v++;
            }
            maxJ--;
            j--;
            i--;
            if (minJ > maxJ) {
                break;
            }
            while (j >= minJ) {
                matrix[i][j--] = v++;
            }
            maxI--;
            i--;
            j++;
            if (minI > maxI) {
                break;
            }
            while (i >= minI) {
                matrix[i--][j] = v++;
            }
            minJ++;
            j++;
            i++;
        }
        return matrix;
    }
}
