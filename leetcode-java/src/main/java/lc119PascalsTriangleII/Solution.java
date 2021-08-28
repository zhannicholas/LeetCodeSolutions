package lc119PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/*
119. 杨辉三角 II
给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。





示例 1:

输入: rowIndex = 3
输出: [1,3,3,1]
示例 2:

输入: rowIndex = 0
输出: [1]
示例 3:

输入: rowIndex = 1
输出: [1,1]


提示:

0 <= rowIndex <= 33


进阶：

你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) {
            return row;
        }
        row.add(1);
        if (rowIndex == 1) {
            return row;
        }
        for (int i = 2; i <= rowIndex; i++) {
            int size = row.size();
            int prev = row.get(0);
            for (int j = 1; j < size; j++) {
                int sum = prev + row.get(j);
                prev = row.get(j);
                row.set(j, sum);

            }
            row.add(1);
        }
        return row;
    }
}
