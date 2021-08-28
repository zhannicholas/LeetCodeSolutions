package lc118PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
118. 杨辉三角
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。





示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(Arrays.asList(1));
        if (numRows == 1) {
            return triangle;
        }
        triangle.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return triangle;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> lastRow = triangle.get(i - 2);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < lastRow.size(); j++) {
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
