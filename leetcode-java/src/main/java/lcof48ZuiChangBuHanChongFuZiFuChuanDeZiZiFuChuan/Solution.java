package lcof48ZuiChangBuHanChongFuZiFuChuanDeZiZiFuChuan;

import java.util.HashSet;
import java.util.Set;

/*
剑指 Offer 48. 最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。



示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

s.length <= 40000
注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = 0; // 滑动窗口
        int maxLen = 1; // 最大长度
        Set<Character> set = new HashSet<>();   // 检查重复字符
        while (start + maxLen - 1 < chars.length) {
            while (end < chars.length && set.add(chars[end])) {
                end++;  // 扩充右边界
            }
            maxLen = Math.max(maxLen, end - start); // 更新最大长度
            while (end < chars.length && chars[start] != chars[end]) {
                set.remove(chars[start++]); // 收缩左边界
            }
            set.remove(chars[start++]);
        }
        return maxLen;
    }
}
