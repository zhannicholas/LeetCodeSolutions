package lc387FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

/*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。



示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2
 */
public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charCountMap.put(chars[i], charCountMap.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (charCountMap.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
