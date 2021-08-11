package lc46Permutations;

import java.util.ArrayList;
import java.util.List;

/*
46. 全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]


提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrace(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }


    private void backtrace(int[] nums, int idx, List<Integer> part, List<List<Integer>> permutations) {
        if (part.size() == nums.length) {
            permutations.add(new ArrayList<>(part));
            return;
        }

        for (int num : nums) {
            // 已经用过的元素不能被再次使用
            if (!part.contains(num)) {
                part.add(num);
                backtrace(nums, idx + 1, part, permutations);
                part.remove(part.size() - 1);
            }
        }
    }
}
