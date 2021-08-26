package lcof30BaoHanMinhanShuDeZhan;

import java.util.Stack;

/*
剑指 Offer 30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.


提示：

各函数的调用总次数不超过 20000 次


注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    private final Stack<Integer> stack; // 数据栈
    private final Stack<Integer> minValueStack; // 辅助栈

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minValueStack.isEmpty()) {
            minValueStack.push(x);
        } else {
            minValueStack.push(Math.min(x, minValueStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minValueStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minValueStack.peek();
    }
}
