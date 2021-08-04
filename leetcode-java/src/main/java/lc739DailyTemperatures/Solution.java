package lc739DailyTemperatures;

import java.util.Stack;

/*
739. 每日温度
请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]


提示：

1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100
 */
public class Solution {
    // 使用单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 栈空，或当前温度低于栈顶温度，入栈
            // 只有当当前温度高于栈顶温度时，我们才计算天数
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int p = stack.pop();
                ans[p] = i - p;
            }
            stack.push(i);
        }

        return ans;
    }
}
