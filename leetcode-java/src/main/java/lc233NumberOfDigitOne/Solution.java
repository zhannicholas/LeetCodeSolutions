package lc233NumberOfDigitOne;

/*
233. 数字 1 的个数
给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。



示例 1：

输入：n = 13
输出：6
示例 2：

输入：n = 0
输出：0


提示：

0 <= n <= 2 * 10^9
 */
public class Solution {
    public int countDigitOne(int n) {
        int cnt = 0;
        // todo: implement
        return cnt;
    }

    /**
     * 内存爆了。。。。
     */
    public int countDigitOne_oom(int n) {
        int cnt = 0;
        int[] memo = new int[n / 10 + 1];
        for (int i = 1; i <= n; i++) {
            int times = 0;
            int k = i;
            while (k != 0) {
                if (k % 10 == 1) {
                    times++;
                }
                k /= 10;
                // 查表
                if (memo[k] != 0) {
                    times += memo[k];
                    break;
                }
            }
            if (i < n / 10) {
                memo[i] = times;
            }
            cnt += times;
        }
        return cnt;
    }

    /**
     * 超时
     */
    public int countDigitOne_timeout(int n) {
        int cnt = 0;
        for (int i = 1; i <=n; i++) {
            cnt += countOne(i);
        }
        return cnt;
    }

    /**
     *  计算数字 k 中 1 出现的次数
     */
    private int countOne(int k) {
        int times = 0;
        while (k != 0) {
            if (k % 10 == 1) {
                times++;
            }
            k /= 10;
        }
        return times;
    }
}
