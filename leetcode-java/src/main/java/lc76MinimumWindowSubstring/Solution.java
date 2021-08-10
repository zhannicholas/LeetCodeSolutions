package lc76MinimumWindowSubstring;

/*
76. 最小覆盖子串
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。



注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。


示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
示例 2：

输入：s = "a", t = "a"
输出："a"
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。


提示：

1 <= s.length, t.length <= 10^5
s 和 t 由英文字母组成


进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class Solution {
    /**
     * 找出 s 中所有包含 t 中所有元素的子串，最短的那个就是答案。
     * 使用滑动窗口实现
     */
    public String minWindow(String s, String t) {
        int slen = s == null ? 0 : s.length();
        int tlen = t == null ? 0 : t.length();

        int uniqueCharCnt = 0;
        int[] cntT = new int[256], cntS = new int[256]; // 用于统计计数，便于判断子串的包含性
        // 初始化 cntT
        for (int i = 0; i < tlen; i++) {
            cntT[t.charAt(i)]++;
            if (cntT[t.charAt(i)] == 1) {
                uniqueCharCnt++;
            }
        }

        int equalCharCnt = 0;   // 统计已匹配上的字母的数量
        int left = 0;  // 滑动窗口的左边界
        int start = 0;  // 满足条件的子串的开始位置
        int minLen = Integer.MAX_VALUE; // 满足条件的子串的最短长度
        for (int right = 0; right < slen; right++) {
            char c = s.charAt(right);
            cntS[c]++;
            if (cntS[c] == cntT[c]) {
                // 成功匹配完一个字母
                equalCharCnt++;
            }
            while (equalCharCnt >= uniqueCharCnt) {
                // 遇到了更短的子串
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                // 收紧左边界
                c = s.charAt(left);
                if (cntS[c] == cntT[c]) {
                    equalCharCnt--;
                }
                cntS[c]--;
                left++;
            }
        }

        return start + minLen <= slen ? s.substring(start, start + minLen) : "";
    }
}
