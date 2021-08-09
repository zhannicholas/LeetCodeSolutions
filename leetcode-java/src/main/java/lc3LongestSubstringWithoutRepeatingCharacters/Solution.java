package lc3LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

/*
3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0


提示：

0 <= s.length <= 5 * 10^4
s 由英文字母、数字、符号和空格组成
 */
public class Solution {
    /**
     * 双指针，滑动窗口区间区间左开右闭
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s == null ? 0 : s.length();
        int ans = 0;
        int left = -1;
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pos[c] > left) {
                left = pos[c];  // 移动到下一个 c 出现的位置
            }
            ans = Math.max(ans, i - left);
            pos[c] = i;
        }
        return ans;
    }
}
