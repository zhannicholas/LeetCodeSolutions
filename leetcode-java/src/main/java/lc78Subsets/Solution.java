package lc78Subsets;

import java.util.ArrayList;
import java.util.List;

/*
78. 子集
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
 */
public class Solution {
    /**
     * 迭代，遍历所有已经找到的子集，每轮向这些已经找到的子集中添加一个元素
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        subsets.add(new ArrayList<>()); // 空集
        for (int num: nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(subsets.get(i));
                list.add(num);
                subsets.add(list);
            }
        }
        return subsets;
    }

    /**
     * 回溯
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            subsets.add(new ArrayList<>()); // 空集
            backtrace(nums, 0, new ArrayList<>(), subsets);
        }
        return subsets;
    }

    private void backtrace(int[] nums, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i == nums.length) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            subset.add(nums[i]);
            subsets.add(new ArrayList<>(subset));
            backtrace(nums, j + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
