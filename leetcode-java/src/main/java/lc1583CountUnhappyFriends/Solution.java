package lc1583CountUnhappyFriends;

/*
1583. 统计不开心的朋友
给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。

对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。

所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。

但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：

x 与 u 的亲近程度胜过 x 与 y，且
u 与 x 的亲近程度胜过 u 与 v
返回 不开心的朋友的数目 。



示例 1：

输入：n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
输出：2
解释：
朋友 1 不开心，因为：
- 1 与 0 配对，但 1 与 3 的亲近程度比 1 与 0 高，且
- 3 与 1 的亲近程度比 3 与 2 高。
朋友 3 不开心，因为：
- 3 与 2 配对，但 3 与 1 的亲近程度比 3 与 2 高，且
- 1 与 3 的亲近程度比 1 与 0 高。
朋友 0 和 2 都是开心的。
示例 2：

输入：n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
输出：0
解释：朋友 0 和 1 都开心。
示例 3：

输入：n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
输出：4


提示：

2 <= n <= 500
n 是偶数
preferences.length == n
preferences[i].length == n - 1
0 <= preferences[i][j] <= n - 1
preferences[i] 不包含 i
preferences[i] 中的所有值都是独一无二的
pairs.length == n/2
pairs[i].length == 2
xi != yi
0 <= xi, yi <= n - 1
每位朋友都 恰好 被包含在一对中
 */
public class Solution {
    /**
     *  开辟一个 nxn 的数组 dissatisfaction，dissatisfaction[x][y] 表示 x 对 y 的好感度是否大于对搭档好友的好感度。
     *  根据不开心的定义，若 dissatisfaction[x][y] = true 且 dissatisfaction[y][x] = true，则说明 x 不开心，
     *
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        boolean[][] dissatisfaction = new boolean[n][n];
        for (int[] pair: pairs) {
            int x = pair[0], y = pair[1];
            for (int i = 0; preferences[x][i] != y; i++) {
                // 由于好感度从前往后递减而 x 与 y 配对，所以在 y 之前的数组值都是 true
                dissatisfaction[x][preferences[x][i]] = true;
            }
            for (int i = 0; preferences[y][i] != x; i++) {
                dissatisfaction[y][preferences[y][i]] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dissatisfaction[i][j] && dissatisfaction[j][i]) {
                    ans++;
                    break;  // 说明 i 对搭档不满意了，i 不开心，跳出，防止重复计算
                }
            }
        }
        return ans;
    }
}
