package lc784LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/*
784. 字母大小写全排列
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。



示例：
输入：S = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入：S = "3z4"
输出：["3z4", "3Z4"]

输入：S = "12345"
输出：["12345"]


提示：

S 的长度不超过12。
S 仅由数字和字母组成。
 */
public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();

        if (s != null && s.length() != 0) {
            // 预处理
            char[][] chars = new char[s.length()][];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('a' <= c && c <= 'z') {
                    chars[i] = new char[]{c, (char)('A' + c - 'a')};
                } else if ('A' <= c && c <= 'Z') {
                    chars[i] = new char[]{c, (char)('a' + c - 'A')};
                } else {
                    chars[i] = new char[]{c};
                }
            }
            // 回溯
            backtrace(chars, 0, new StringBuilder(), permutations);
        }
        return permutations;
    }

    private void backtrace(char[][] chars, int i, StringBuilder part, List<String> permutations) {
        if (i == chars.length) {
            permutations.add(part.toString());
            return;
        }
        for (char c: chars[i]) {
            part.append(c);
            backtrace(chars, i + 1, part, permutations);
            part.deleteCharAt(part.length() - 1);
        }
    }
}
