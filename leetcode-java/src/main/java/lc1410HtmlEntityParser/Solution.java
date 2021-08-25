package lc1410HtmlEntityParser;

import java.util.HashMap;
import java.util.Map;

/*
1410. HTML 实体解析器
「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。

HTML 里这些特殊字符和它们对应的字符实体包括：

双引号：字符实体为 &quot; ，对应的字符是 " 。
单引号：字符实体为 &apos; ，对应的字符是 ' 。
与符号：字符实体为 &amp; ，对应对的字符是 & 。
大于号：字符实体为 &gt; ，对应的字符是 > 。
小于号：字符实体为 &lt; ，对应的字符是 < 。
斜线号：字符实体为 &frasl; ，对应的字符是 / 。
给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。



示例 1：

输入：text = "&amp; is an HTML entity but &ambassador; is not."
输出："& is an HTML entity but &ambassador; is not."
解释：解析器把字符实体 &amp; 用 & 替换
示例 2：

输入：text = "and I quote: &quot;...&quot;"
输出："and I quote: \"...\""
示例 3：

输入：text = "Stay home! Practice on Leetcode :)"
输出："Stay home! Practice on Leetcode :)"
示例 4：

输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
输出："x > y && x < y is always false"
示例 5：

输入：text = "leetcode.com&frasl;problemset&frasl;all"
输出："leetcode.com/problemset/all"


提示：

1 <= text.length <= 10^5
字符串可能包含 256 个ASCII 字符中的任意字符。
 */
public class Solution {
    public String entityParser(String text) {
        Map<String, Character> map = new HashMap<>();
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');

        StringBuilder ans = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            while (i < chars.length && chars[i] != '&') {
                ans.append(chars[i++]);
            }
            if (i >= chars.length) {
                break;
            }
            // 开始匹配特殊字符实体
            int j = i + 3;
            while (j < chars.length && j <= i + 6 && chars[j] != ';') {
                j++;
            }
            if (j >= chars.length || j > i + 6) {
                for (int k = i; k <= Math.min(chars.length - 1, j); k++) {
                    ans.append(chars[k]);
                }
            } else {
                StringBuilder key = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    key.append(chars[k]);
                }
                // 处理 &&gt; 这种情况
                Character c = map.get(key.toString());
                if (c != null) {
                    ans.append(c);
                } else {
                    ans.append(chars[i]);
                    j = i;
                }
            }
            i = j;
        }

        return ans.toString();
    }
}
