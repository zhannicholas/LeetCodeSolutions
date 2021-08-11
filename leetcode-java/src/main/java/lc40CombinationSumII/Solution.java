package lc40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

注意：解集不能包含重复的组合。



示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]


提示:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates != null && candidates.length > 0) {
            Arrays.sort(candidates);
            backtrace(candidates, 0, 0, target, new ArrayList<>(), combinations);
        }
        return combinations;
    }

    private void backtrace(int[] candidates, int sum, int idx, int target, List<Integer> part, List<List<Integer>> combinations) {
        if (sum == target) {
            combinations.add(new ArrayList<>(part));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            part.add(candidates[i]);
            backtrace(candidates, sum + candidates[i], i + 1, target, part, combinations);
            part.remove(part.size() - 1);
            // 使用完需要去重
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}

