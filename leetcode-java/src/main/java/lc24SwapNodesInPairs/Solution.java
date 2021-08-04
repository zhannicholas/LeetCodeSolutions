package lc24SwapNodesInPairs;

/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null && cur.next != null) {
            ListNode nextNext = cur.next.next;
            prev.next = cur.next;
            prev = prev.next;
            prev.next = cur;
            prev = prev.next;
            prev.next = null;
            cur = nextNext;
        }

        if (cur != null) {
            prev.next = cur;
        }

        return dummy.next;
    }
}
