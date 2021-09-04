package lcof46BaShuZiFanYiChengZiFuChuan;

/*
剑指 Offer 46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


提示：

0 <= num < 2^31
 */
public class Solution {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        int[] numbers = new int[String.valueOf(num).length()];
        int temp = num;
        for (int i = numbers.length - 1; i >= 0; i--) {
            numbers[i] = temp % 10;
            temp /= 10;
        }
        int n = numbers.length;
        int[] dp = new int[n];  // dp[i] 表示以第 i 个字符结尾的数字的翻译总数
        dp[0] = 1;
        dp[1] = translateTwoNumber(numbers[0], numbers[1]) ? 2 : 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + (translateTwoNumber(numbers[i - 1], numbers[i]) ? dp[i - 2] : 0);
        }
        return dp[n - 1];
    }

    private boolean translateTwoNumber(int num1, int num2) {
        int num = num1 * 10 + num2;
        return 10 <= num && num <= 25;
    }
}
