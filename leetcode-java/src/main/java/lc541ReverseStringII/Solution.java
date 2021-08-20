package lc541ReverseStringII;

/*
541. 反转字符串 II
给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


示例 1：

输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：

输入：s = "abcd", k = 2
输出："bacd"


提示：

1 <= s.length <= 10^4
s 仅由小写英文组成
1 <= k <= 10^4
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0, end = (k << 1) - 1;
        while (end < n) {
            reverse(chars, start, start + k - 1);
            start = end + 1;
            end = start + (k << 1) - 1;
        }
        if (start + k <= n) {
            reverse(chars, start, start + k - 1);
        } else {
            reverse(chars, start, n - 1);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
}
