package lc567PermutationInString;

/*
567. 字符串的排列
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，s1 的排列之一是 s2 的 子串 。



示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false


提示：

1 <= s1.length, s2.length <= 10^4
s1 和 s2 仅包含小写字母
 */
public class Solution {
    /**
     * 维护一个大小为 s1.length 的滑动窗口，通过统计字符频次来判断是否是排列
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int left = 0;  // 左边界
        int[] s1Cnt = new int[256], s2Cnt = new int[256];   // 存放两个字符串中各字母的出现次数

        for (int i = 0; i < len1; i++) {
            s1Cnt[s1.charAt(i)]++;
        }

        for (int right = 0; right < len2; right++) {
            s2Cnt[s2.charAt(right)]++;
            // 初始化窗口
            if (right < len1 - 1) {
                continue;
            }

            boolean same = true;
            for (int i = 0; i < 256 && same; i++) {
                same = s2Cnt[i] == s1Cnt[i];
            }
            if (same) {
                return true;
            }
            s2Cnt[s2.charAt(left++)]--;
        }

        return false;
    }
}
