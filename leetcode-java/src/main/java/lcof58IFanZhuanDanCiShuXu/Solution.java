package lcof58IFanZhuanDanCiShuXu;

/*
剑指 Offer 58 - I. 翻转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。



示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/

注意：此题对比原题有改动
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int left = s.length() - 1, right;
        while (left >= 0) {
            // 去除空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            // right 指向单词的末尾
            right = left;
            // left 指向单词开头
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            for (int i = left + 1; i <= right; i++) {
                ans.append(s.charAt(i));
            }
            ans.append(' ');
        }
        return ans.toString().trim();
    }
}
