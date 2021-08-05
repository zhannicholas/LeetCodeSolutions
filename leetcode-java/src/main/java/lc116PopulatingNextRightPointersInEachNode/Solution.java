package lc116PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

/*
116. 填充每个节点的下一个右侧节点指针
给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。



进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。


示例：



输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。


提示：

树中节点的数量少于 4096
-1000 <= node.val <= 1000
 */
public class Solution {
    /**
     * 由于题目给出的是完美二叉树，所以每个节点的左右子节点都存在。仔细观察可以得出以下规律：
     * 对于节点 node，连接后有：node.left.next = node.right
     * 假设节点 node 所在层的下一个节点是 node2，则：node.right.next = node2.left
     *
     * 所以我们对完美二叉树进行层序遍历，进行连接即可。每层的最后一个节点不做处理
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        // 开始利用 FIFO 队列进行层序遍历
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    node.left.next = node.right;
                }
                if (qSize > 1 && node.right != null) {
                    node.right.next = queue.peek().left;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                qSize--;
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
