package lcof50DiYiGeZhiChuXianYiCiDeZiFu;

import java.util.HashMap;
import java.util.Map;

/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "


限制：

0 <= s 的长度 <= 50000
 */
public class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (map.containsKey(c)) {
                map.put(c, false);
            } else {
                map.put(c, true);
            }
        }
        for (char c: chars) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
