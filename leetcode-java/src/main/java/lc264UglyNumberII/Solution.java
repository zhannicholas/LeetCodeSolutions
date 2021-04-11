package lc264UglyNumberII;

/*
264. 丑数 II
给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。



示例 1：

输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
示例 2：

输入：n = 1
输出：1
解释：1 通常被视为丑数。


提示：

1 <= n <= 1690
 */
public class Solution {
    /**
     * 若 x 是丑数，那么 2x、3x、5x 也是抽数。最小的丑数是 1，然后是 1x2 1x3 1x2x2 1x5 ...
     * 问题在于如何维护有序性。
     * 维护 3 个指针，分别用来标记 2、3、5 当前乘的是哪个数，每次取最小的数，然后更新指针指向
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 =dp[i2] * 2, num3 = dp[i3] * 3, num5 = dp[i5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            // 下面不能用 else if，因为需要去重
            if (dp[i] == num2) {
                i2++;
            }
            if (dp[i] == num3) {
                i3++;
            }
            if (dp[i] == num5) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
