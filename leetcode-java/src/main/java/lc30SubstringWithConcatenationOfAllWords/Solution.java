package lc30SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
30. 串联所有单词的子串
给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。



示例 1：

输入：s = "barfoothefoobarman", words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2：

输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
输出：[]
示例 3：

输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
输出：[6,9,12]


提示：

1 <= s.length <= 10^4
s 由小写英文字母组成
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] 由小写英文字母组成
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLength = words[0].length();
        Map<String, Integer> counterW = new HashMap<>(); // 用于统计列表中每个单词出现的次数
        for (String word: words) {
            Integer count = counterW.get(word);
            if (count == null) {
                counterW.put(word, 1);
            } else {
                counterW.put(word, count + 1);
            }
        }

        for (int start = 0; start < wordLength; start++) {
            Map<String, Integer> counterS = new HashMap<>();    // 用于统计字符串中匹配到的单词次数
            int left = start - wordLength;  // 左开右闭区间的左边界
            int equalCount = 0; // s 中匹配上哈希表中单词的数量
            int cnt = 0;    // 辅助统计窗口大小
            for (int right = start; right + wordLength <= s.length(); right += wordLength) {
                // 切分出单词
                String temp = s.substring(right, right + wordLength);
                Integer count = counterS.get(temp);
                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }
                counterS.put(temp, count);

                if (count.equals(counterW.get(temp))) {
                    equalCount++;
                }

                cnt++;

                // 初始化滑动窗口
                if (cnt < words.length) {
                    continue;
                }

                // 成功匹配出一个子串
                if (equalCount == counterW.size()) {
                    ans.add(left + wordLength);
                }

                // 收缩左边界
                left += wordLength;
                String out = s.substring(left, left + wordLength);
                if (counterS.get(out).equals(counterW.get(out))) {
                    equalCount--;
                }
                if (counterS.get(out).equals(1)) {
                    counterS.remove(out);
                } else {
                    counterS.put(out, counterS.get(out) - 1);
                }
            }
        }

        return ans;
    }
}
