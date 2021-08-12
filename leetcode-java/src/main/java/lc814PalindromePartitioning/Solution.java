package lc814PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/*
131. 分割回文串
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。



示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> palindromes = new ArrayList<>();
        if (s != null && s.length() > 0) {
            backtrace(s, 0, new ArrayList<>(), palindromes);
        }
        return palindromes;
    }

    /**
     * 从 start 开始搜索回文串
     */
    private void backtrace(String s, int start, List<String> palindrome, List<List<String>> palindromes) {
        if (start == s.length()) {
            palindromes.add(new ArrayList<>(palindrome));
            return;
        }
        // 搜索以 s[start] 开头的所有子串，即s[start..i]
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                palindrome.add(s.substring(start, i + 1));
                backtrace(s, i + 1, palindrome, palindromes);
                palindrome.remove(palindrome.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
