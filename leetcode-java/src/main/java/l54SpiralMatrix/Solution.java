package l54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：


输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
public class Solution {
    // 模拟，注意边界条件
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int minI = 0, maxI = m - 1;
        int minJ = 0, maxJ = n - 1;
        int i = minI, j = minJ;
        List<Integer> ans = new ArrayList<>();
        while ((minI <= i && i <= maxI) && (minJ <= j && j <= maxJ)) {
            while (j <= maxJ) {
                ans.add(matrix[i][j++]);
            }
            i++;
            minI++;
            j--;
            if (minI > maxI) {
                break;
            }
            while (i <= maxI) {
                ans.add(matrix[i++][j]);
            }
            maxJ--;
            j--;
            i--;
            if (minJ > maxJ) {
                break;
            }
            while (j >= minJ) {
                ans.add(matrix[i][j--]);
            }
            maxI--;
            i--;
            j++;
            if (minI > maxI) {
                break;
            }
            while (i >= minI) {
                ans.add(matrix[i--][j]);
            }
            minJ++;
            j++;
            i++;
        }

        return ans;
    }
}
