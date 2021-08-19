package lc67AddBinary;

/*
67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。



示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"


提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int ia = a.length() - 1, ib = b.length() - 1;
        while (ia >= 0 && ib >= 0) {
            int sum = (a.charAt(ia--) - '0') + (b.charAt(ib--) - '0') + carry;
            carry = sum >> 1;
            ans.insert(0, sum % 2);
        }
        while (ia >= 0) {
            int sum = a.charAt(ia--) - '0' + carry;
            carry = sum >> 1;
            ans.insert(0, sum % 2);
        }
        while (ib >= 0) {
            int sum = b.charAt(ib--) - '0' + carry;
            carry = sum >> 1;
            ans.insert(0, sum % 2);
        }
        if (carry != 0) {
            ans.insert(0, carry);
        }
        return ans.toString();
    }
}
