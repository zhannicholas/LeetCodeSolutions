package lc852PeakIndexInAMountainArray;

/*
852. 山脉数组的峰顶索引

符合下列属性的数组 arr 称为 山脉数组 ：
arr.length >= 3
存在 i（0 < i < arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。

 

示例 1：

输入：arr = [0,1,0]
输出：1
示例 2：

输入：arr = [0,2,1,0]
输出：1
示例 3：

输入：arr = [0,10,5,2]
输出：1
示例 4：

输入：arr = [3,4,5,1]
输出：2
示例 5：

输入：arr = [24,69,100,99,79,78,67,36,26,19]
输出：2

提示：

3 <= arr.length <= 10^4
0 <= arr[i] <= 10^6
题目数据保证 arr 是一个山脉数组

进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 */
public class Solution {
    /**
     * 二分查找
     */
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (arr[m - 1] < arr[m] && arr[m] > arr[m + 1]) {
                return m;
            } else if (arr[m - 1] < arr[m] && arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
