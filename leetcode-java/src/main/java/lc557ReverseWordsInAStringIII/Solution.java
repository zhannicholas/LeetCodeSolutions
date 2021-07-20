package lc557ReverseWordsInAStringIII;

/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。



示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"


提示：

在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverseString(chars, i, j - 1);
            j++;
            i = j;
        }


        return new String(chars);
    }

    private void reverseString(char[] s, int i, int j) {
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
