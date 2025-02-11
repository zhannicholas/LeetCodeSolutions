package lc69Sqrtx;

/*
69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long start = 1, end = x >> 1;
        while (start <= end) {
            long mid = start + ((end - start) >> 1);
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square > x) {
                end = mid - 1;
            } else {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                }
                start = mid + 1;
            }
        }
        return (int) start;
    }
}
