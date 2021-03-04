package lc354RussianDollEnvelopes;

/*
354. 俄罗斯套娃信封问题
给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。

当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

注意：不允许旋转信封。


示例 1：

输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出：3
解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
示例 2：

输入：envelopes = [[1,1],[1,1],[1,1]]
输出：1


提示：

1 <= envelopes.length <= 5000
envelopes[i].length == 2
1 <= wi, hi <= 104
*/


import java.util.Arrays;

public class Solution {
    /**
     * 先排序，然后问题转化为最长递增子序列问题
     */
    public int maxEnvelopes_dp(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        // 优先按照宽度排序，宽度相同则按高度排序。升序排列
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return 1;
            }
        });

        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        // dp[i] = max(dp[j]) + 1, 0 <= j < i && envelope[j] < envelope[i]
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
