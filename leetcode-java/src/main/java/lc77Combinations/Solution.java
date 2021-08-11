package lc77Combinations;

import java.util.ArrayList;
import java.util.List;

/*
77. 组合
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。



示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：

输入：n = 1, k = 1
输出：[[1]]


提示：

1 <= n <= 20
1 <= k <= n
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrace(n, 1, k, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrace(int n, int i, int k, List<Integer> part, List<List<Integer>> combinations) {
        if (part.size() == k) {
            combinations.add(new ArrayList<>(part));
            return;
        }
        for (int j = i; j <= n; j++) {
            part.add(j);
            backtrace(n, j + 1, k, part, combinations);
            part.remove(part.size() - 1);
        }
    }
}
