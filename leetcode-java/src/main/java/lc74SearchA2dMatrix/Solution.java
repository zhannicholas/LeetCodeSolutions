package lc74SearchA2dMatrix;
/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。


示例 1：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int rs = 0, re = m - 1;
        // 二分定位到行：找 target 的下界
        while (rs < re) {
            int mid = rs + ((re - rs + 1) >> 1);
            if (matrix[mid][0] > target) {
                re = mid - 1;
            } else if (matrix[mid][0] == target) {
                return true;
            } else {
                rs = mid;
            }
        }
        // 二分定位到列
        int cs = 0, ce = n - 1;
        while (cs <= ce) {
            int mid = cs + ((ce - cs) >> 1);
            if (matrix[rs][mid] == target) {
                return true;
            } else if (matrix[rs][mid] > target) {
                ce = mid - 1;
            } else {
                cs = mid + 1;
            }
        }
        return false;
    }
}
