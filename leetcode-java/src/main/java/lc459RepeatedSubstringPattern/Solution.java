package lc459RepeatedSubstringPattern;

/*
459. 重复的子字符串
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        } else if (s.length() <= 1) {
            return false;
        }
        int n = s.length();
        // 选取长度为 len 的子串去进行匹配
        for (int len = 1; len <= (n >> 1); len++) {
            // n 必须是 len 的整数倍
            if (n % len == 0) {
                int times = n / len;    // 需要匹配的次数
                int matchedTimes = 1;
                boolean matchFailed = false;
                // 第一段将作为匹配串，所以 t 从 1 开始，比较 times - 1 次
                for (int t = 1; t < times; t++) {
                    // 现在实际上是匹配 s[0..len-1] 与 s[len*t..len*t+len-1] 是否相同
                    for (int l = 0; l < len; l++) {
                        if (s.charAt(l) != s.charAt(len * t + l)) {
                            matchFailed = true;
                            break;
                        }
                    }
                    if (matchFailed) {
                        break;
                    }
                    matchedTimes++;
                }
                if (matchedTimes == times) {
                    return true;
                }
            }
        }

        return false;
    }
}
