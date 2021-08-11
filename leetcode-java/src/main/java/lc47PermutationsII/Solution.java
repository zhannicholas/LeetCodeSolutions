package lc47PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            Arrays.sort(nums);
            backtrace(nums, 0, new boolean[nums.length], new ArrayList<>(), permutations);
        }

        return permutations;
    }

    private void backtrace(int[] nums, int idx, boolean[] used, List<Integer> part, List<List<Integer>> permutations) {
        if (idx == nums.length) {
            permutations.add(new ArrayList<>(part));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !(i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                part.add(nums[i]);
                used[i] = true;
                backtrace(nums, idx + 1, used, part, permutations);
                part.remove(part.size() - 1);
                used[i] = false;
            }
        }
    }
}
