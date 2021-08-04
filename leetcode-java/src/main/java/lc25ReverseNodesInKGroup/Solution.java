package lc25ReverseNodesInKGroup;

/*
25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。


示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：


输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
示例 3：

输入：head = [1,2,3,4,5], k = 1
输出：[1,2,3,4,5]
示例 4：

输入：head = [1], k = 1
输出：[1]
提示：

列表中节点的数量在范围 sz 内
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            int n = k;
            ListNode cur = prev;
            while (n > 0) {
                cur = cur.next;
                n--;
                if (cur == null) {
                    return dummy.next;  // 最后一部分不足 k 个节点，直接返回
                }
            }
            // 以上循环结束时，cur 指向待翻转片段的最后一个节点，prev.next则是待翻转片段的第一个节点

            ListNode next = cur.next;   // 下一部分的首节点
            ListNode[] headTail = reverse(prev.next, cur);
            prev.next = headTail[0];   // 连接翻转后的首节点
            headTail[1].next = next;    // 连接翻转后的尾节点
            prev = headTail[1];
        }

        return dummy.next;
    }


    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        while (cur != tail) {
            ListNode tn = tail.next, cn = cur.next;
            tail.next = cur;
            cur.next = tn;
            cur = cn;
        }
        return new ListNode[]{tail, head};
    }
}
