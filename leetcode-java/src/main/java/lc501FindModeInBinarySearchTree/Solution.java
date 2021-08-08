package lc501FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
501. 二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序

进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class Solution {
    /**
     * 利用二叉搜索树中序遍历的有序性
     */
    public int[] findMode(TreeNode root) {
        List<Integer> modeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int maxCnt = 0, preVal = 0, curCnt = 0;
        while (root != null || !stack.isEmpty()) {
            // 深入左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 左子树到头，弹栈
            root = stack.pop();
            // 若和之前的值相等，则累加计数值，否则重置计数值
            if (root.val == preVal) {
                curCnt++;
            } else {
                preVal = root.val;
                curCnt = 1;
            }
            // 众数可能有多个
            if (curCnt == maxCnt) {
                modeList.add(root.val);
            }
            // 更新
            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                modeList.clear();
                modeList.add(root.val);
            }
            // 转向右子树
            root = root.right;
        }

        int[] ans = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) {
            ans[i] = modeList.get(i);
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode (int val) {this.val = val;}
}
