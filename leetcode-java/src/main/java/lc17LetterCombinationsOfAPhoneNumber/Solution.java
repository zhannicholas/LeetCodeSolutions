package lc17LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Solution {
    private char[][] chars = new char[][]{
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() > 0) {
            backtrace(digits, 0, new StringBuilder(), combinations);
        }
        return combinations;
    }

    private void backtrace(String digits, int i, StringBuilder part, List<String> combinations) {
        if (i == digits.length()) {
            combinations.add(part.toString());
            return;
        }

        for (char c: chars[digits.charAt(i) - '1']) {
            part.append(c);
            backtrace(digits, i + 1, part, combinations);
            part.deleteCharAt(part.length() - 1);
        }
    }
}
