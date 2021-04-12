package lc179LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/*
179. 最大数
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。



示例 1：

输入：nums = [10,2]
输出："210"
示例 2：

输入：nums = [3,30,34,5,9]
输出："9534330"
示例 3：

输入：nums = [1]
输出："1"
示例 4：

输入：nums = [10]
输出："10"


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 10^9
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] nums2 = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums2, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String num: nums2) {
            sb.append(num);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
