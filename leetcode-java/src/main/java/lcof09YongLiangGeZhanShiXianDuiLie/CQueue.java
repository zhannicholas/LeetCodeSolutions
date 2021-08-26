package lcof09YongLiangGeZhanShiXianDuiLie;

import java.util.Stack;

/*
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class CQueue {
    /**
     * 维护两个栈，一个用于插入，一个用于删除
     */
    private final Stack<Integer> insertStack, deleteStack;

    public CQueue() {
        insertStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        insertStack.push(value);
    }

    public int deleteHead() {
        if (!deleteStack.isEmpty()) {
            return deleteStack.pop();
        }
        while (!insertStack.isEmpty()) {
            deleteStack.push(insertStack.pop());
        }
        if (deleteStack.isEmpty()) {
            return -1;
        }
        return deleteStack.pop();
    }
}
