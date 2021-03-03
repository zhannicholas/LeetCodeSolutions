package lc338CountingBits;

/*
338. 比特位计数
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */

public class Solution {
    /**
     * 根据官方提示2得到的解题思路：找规律
     * 分组：[1],[2-3],[4-7],[8-15],[16-31]...
     * 设定一个 inc 值，第 j 组的 inc 值刚好为 第 j 组元素的数量，即 inc 的值为：1,2,4,8,...
     * 用 i 来遍历 num，当 i = inc * 2 时，inc *= 2，i 的初始值为 1
     * bits[i] = bits[i - inc] + 1
     */
    public int[] countBits_group(int num) {
        int[] bits = new int[num + 1];
        int inc = 1;
        for (int i = 1; i <= num; i++) {
            if (i == inc << 1) {
                inc <<= 1;
            }
            bits[i] = bits[i - inc] + 1;
        }
        return bits;
    }

    /**
     * 根据奇偶性计算（官方提示2）
     */
    public int[] countBits_odd_even(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                // 奇数的最后一位是1，剩下部分中1的个数等于右移一位后结果中1的个数
                bits[i] = bits[i >> 1] + 1;
            } else {
                // 偶数最后一位是0，剩下部分中1的个数等于右移一位后结果中1的个数
                bits[i] = bits[i >> 1];
            }
        }
        return bits;
    }

    public int[] countBits_odd_even_pro(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
