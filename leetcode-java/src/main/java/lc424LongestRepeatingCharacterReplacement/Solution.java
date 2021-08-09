package lc424LongestRepeatingCharacterReplacement;

/*
424. 替换后的最长重复字符
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意：字符串长度 和 k 不会超过 10^4。



示例 1：

输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class Solution {
    /**
     * 滑动窗口
     * 先来看一个特殊情况，当 k = 0 时，问题退化为求最长重复字母构成的子串的长度。
     * 这样一来就可以将原问题看成：求有限区间内进行 k 此任意字母替换得到的重复字母构成的子串的最长长度。
     * 为了最大化替换效益，我们需要跟踪到窗口内出现频率最高的那个字母，然后把其它字母替换掉。
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] cnt = new int[26];    // 存放各个字母出现的次数
        int left = 0, right = 0;    // 滑动窗口
        int maxCnt = 0; // 存放区间内出现频率最高的那个字母的出现次数
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c - 'A']++;
            maxCnt = Math.max(maxCnt, cnt[c - 'A']);    // 更新最大出现频率
            if (right - left + 1 > maxCnt + k) {
                cnt[s.charAt(left++) - 'A']--;  // 收紧左边界
            }
        }

        return right - left;
    }
}
