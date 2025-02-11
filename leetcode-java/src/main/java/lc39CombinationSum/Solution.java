package lc39CombinationSum;

import java.util.ArrayList;
import java.util.List;

/*
39. 组合总和
给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。

candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。

对于给定的输入，保证和为 target 的唯一组合数少于 150 个。



示例 1：

输入: candidates = [2,3,6,7], target = 7
输出: [[7],[2,2,3]]
示例 2：

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
示例 3：

输入: candidates = [2], target = 1
输出: []
示例 4：

输入: candidates = [1], target = 1
输出: [[1]]
示例 5：

输入: candidates = [1], target = 2
输出: [[1,1]]


提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates != null && candidates.length > 0) {
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
            backtrace(candidates, sum + candidates[i], i, target, part, combinations);
            part.remove(part.size() - 1);
        }
    }
}
