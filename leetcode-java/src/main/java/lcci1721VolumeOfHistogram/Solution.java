package lcci1721VolumeOfHistogram;

/*
面试题 17.21. 直方图的水量
给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
*/
public class Solution {
    /**
     *  用 leftHeight[i] 表示 height[i] 左侧的最高点，rightHeight[i] 表示 height[i] 右侧的最高点
     *  经过观察，可以发现：height[i] 处所能容纳的最大水量为：min{leftHeight[i], rightHeight[i]} - height[i] 或 0
     *  对所有的 i 求和即可得到直方图能够容纳的水量。
     *  现在的问题转化为如何求 leftHeight[i] 与 rightHeigt[i] ?
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];

        for (int i = 1; i < n; i++) {
            leftHeight[i] = Math.max(leftHeight[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i + 1], height[i + 1]);
        }

        int volume = 0;
        for (int i = 0; i < n; i++) {
            int t = Math.min(leftHeight[i], rightHeight[i]);
            if (t > height[i]) {
                volume += t - height[i];
            }
        }

        return volume;
    }
}
