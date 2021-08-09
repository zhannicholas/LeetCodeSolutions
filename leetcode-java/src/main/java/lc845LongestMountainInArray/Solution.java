package lc845LongestMountainInArray;

/*
845. 数组中的最长山脉
我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

B.length >= 3
存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
（注意：B 可以是 A 的任意子数组，包括整个数组 A。）

给出一个整数数组 A，返回最长 “山脉” 的长度。

如果不含有 “山脉” 则返回 0。



示例 1：

输入：[2,1,4,7,3,2,5]
输出：5
解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
示例 2：

输入：[2,2,2]
输出：0
解释：不含 “山脉”。


提示：

0 <= A.length <= 10000
0 <= A[i] <= 10000
 */
public class Solution {
    public int longestMountain(int[] arr) {
        int maxLength = 0, n = arr.length;
        int left = 0, right = 0;
        for (; right < n; right++) {
            // 先向右收紧左边界，找到上升点
            while (left < n - 1 && arr[left] >= arr[left + 1]) {
                left++;
            }
            right = left + 1;
            // 找到波峰
            while (right < n - 1 && arr[right] < arr[right + 1]) {
                right++;
            }
            if (right == n - 1) {
                break;
            }
            if (right < n - 1 && arr[right] == arr[right + 1]) {
                // 平顶山，不满足定义，更新左边界
                left = right;
                continue;
            }
            // 找到波谷
            while (right < n - 1 && arr[right] > arr[right + 1]) {
                right++;
            }
            // 找到山脉，更新左边界
            maxLength = Math.max(maxLength, right - left + 1);
            left = right;
        }

        return maxLength < 3 ? 0 : maxLength;
    }
}
