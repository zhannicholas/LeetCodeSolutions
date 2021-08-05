package lc84LargestRectangleInHistogram;

import java.util.Stack;

/*
84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。



示例 1:



输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2：



输入： heights = [2,4]
输出： 4


提示：

1 <= heights.length <=10^5
0 <= heights[i] <= 10^4
 */
public class Solution {
    /**
     * 使用单调栈，对于每一块木板，计算将其作为矩形高度时能得到的最大矩形。具体做法是：分别找到木板左右两侧第一个更短的位置，取这两个位置的距离作为宽度即可。
     */
    public int largestRectangleArea(int[] heights) {
        int[] smallerLeft = new int[heights.length], smallerRight = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                smallerLeft[stack.pop()] = i;
            }
            stack.push(i);
        }
        // 左侧没有更小的元素，那么矩形的宽度可以一直向左延伸到第一个元素
        while (!stack.isEmpty()) {
            smallerLeft[stack.pop()] = -1;
        }

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                smallerRight[stack.pop()] = i;
            }
            stack.push(i);
        }
        // 右侧没有更小的元素，那么矩形的宽度可以一直向右延伸到最后一个元素
        while (!stack.isEmpty()) {
            smallerRight[stack.pop()] = heights.length;
        }

        int largestRectangle = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            largestRectangle = Math.max(largestRectangle, heights[i] * (smallerRight[i] - smallerLeft[i] - 1));
        }

        return largestRectangle;
    }
}
