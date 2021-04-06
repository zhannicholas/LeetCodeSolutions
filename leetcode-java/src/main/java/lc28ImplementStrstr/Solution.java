package lc28ImplementStrstr;

/*
28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        }
        int len1 = haystack.length(), len2 = needle.length();
        char first = needle.charAt(0);
        int max = len1 - len2;
        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + len2 - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++,k++);
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }
}
