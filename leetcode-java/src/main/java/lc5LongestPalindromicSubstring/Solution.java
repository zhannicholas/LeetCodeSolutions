package lc5LongestPalindromicSubstring;

/*
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Solution {
    /**
     *  回文串的长度可能是奇数（aba），也可能是偶数（abba），所以我们采用中心扩散的方式，枚举所有中心点
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int start = 0, maxLen = 1; // 最长回文子串的起始点，以及长度
        for (int m = 1; m < len; m++) {
            // 先枚举奇数长度的回文子串，m 即为中间字符的位置
            int i = m, j = m;
            while ((i >= 0 && j < len) && (s.charAt(i) == s.charAt(j))) {
                i--;
                j++;
            }
            i++;
            j--;
            if (j - i + 1 > maxLen) {
                start = i;
                maxLen = j - i + 1;
            }
            // 再枚举偶数长度的回文子串，m 为第二个中间字符的位置
            i = m - 1;
            j = m;
            while ((i >= 0 && j < len) && (s.charAt(i) == s.charAt(j))) {
                i--;
                j++;
            }
            i++;
            j--;
            if (j - i + 1 > maxLen) {
                start = i;
                maxLen = j - i + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
