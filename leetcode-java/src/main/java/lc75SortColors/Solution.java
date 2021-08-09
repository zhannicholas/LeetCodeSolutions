package lc75SortColors;

/*
75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。



示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]
示例 3：

输入：nums = [0]
输出：[0]
示例 4：

输入：nums = [1]
输出：[1]


提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2


进阶：

你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution {
    /**
     * 使用三路快排的划分思想
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        // i0：下一个放0的位置
        // i2：下一个放2的位置
        int i0 = 0, i2 = n - 1;
        // 先处理数组两端
        while (i0 < n && nums[i0] == 0) {
            i0++;
        }
        while (i2 >= 0 && nums[i2] == 2) {
            i2--;
        }
        int i = i0; // 遍历数组的指针
        while (i <= i2) {
            if (nums[i] == 0) {
                swap(nums, i, i0++);
            } else if (nums[i] == 2) {
                swap(nums, i, i2--);
                i--;    // 因为是向后遍历，此时的 i 实际上是被交换过来的那个数，需要重新检查
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
