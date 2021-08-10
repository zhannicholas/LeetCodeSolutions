package lc763PartitionLabels;

import java.util.ArrayList;
import java.util.List;

/*
763. 划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。



示例：

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。


提示：

S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
 */
public class Solution {
    /**
     * 贪心策略：查看第一个字母 s[0]，找到 s[0] 最后出现的位置 s[e]，对s[1..e-1]中的字母执行同样的操作
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        int n = s.length();
        int[] rightmostPos = new int[26];   // 存放每个字母最右出现的位置
        // 计算字母最后出现的位置
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > rightmostPos[c - 'a']) {
                rightmostPos[c - 'a'] = i;
            }
        }

        int left = 0, right = rightmostPos[s.charAt(0) - 'a'];   // 左右边界
        while (right < n) {
            int p = left;
            while (p <= right) {
                right = Math.max(right, rightmostPos[s.charAt(p++) - 'a']);
            }
            ans.add(right - left + 1);
            right++;
            left = right;
        }
        return ans;
    }
}
