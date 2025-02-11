package lc216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (k <= n) {
            backtrace(n, k, 1, 0, new ArrayList<>(), combinations);
        }
        return combinations;
    }

    private void backtrace(int n, int k, int i, int sum, List<Integer> part, List<List<Integer>> combinations) {
        if (sum > n || (part.size() == k && sum != n)) {
            return;
        }
        if (part.size() == k) {
            combinations.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j <= 9; j++) {
            part.add(j);
            sum += j;
            backtrace(n, k, j + 1, sum, part, combinations);
            part.remove(part.size() - 1);
            sum -= j;
        }
    }
}
