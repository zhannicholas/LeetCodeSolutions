package lcof53ZaiPaiXuShuZuZhongChaZhaoShuzi;

/*
剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。



示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0


提示：

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 是一个非递减数组
-10^9 <= target <= 10^9
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int position = -1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                position = m;
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (position == -1) {
            return 0;
        }
        int cnt = 1;
        for (int i = position - 1; i >= 0 && nums[i] == target; i--) {
            cnt++;
        }
        for (int i = position + 1; i < nums.length && nums[i] == target; i++) {
            cnt++;
        }
        return cnt;
    }
}
