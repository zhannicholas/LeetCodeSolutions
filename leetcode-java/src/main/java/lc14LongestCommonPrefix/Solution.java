package lc14LongestCommonPrefix;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。


提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String commonPrefix = longestCommonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    private String longestCommonPrefix(String s1, String s2) {
        StringBuilder commonPrefix = new StringBuilder();
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                commonPrefix.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }
}
