package lc92ReverseLinkedListII;

/*
92. 反转链表 II
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？
*/

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode part1Tail = dummy;
        // 找到待反转部分的前一个节点
        for (int i = 0; i < left - 1; i++) {
            part1Tail = part1Tail.next;
        }
        // 前进到待反转部分的最后一个节点
        ListNode rightNode = part1Tail;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 将原链表断开成三部分
        ListNode leftNode = part1Tail.next;
        ListNode part3Head = rightNode.next;
        part1Tail.next = null;
        rightNode.next = null;
        // 反转 leftNode...rightNode 部分
        reverseList(leftNode);

        // 重新拼接
        part1Tail.next = rightNode;
        leftNode.next = part3Head;

        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode dummyNext = dummy.next;
            ListNode curNext = cur.next;
            cur.next = dummyNext;
            dummy.next = cur;
            cur = curNext;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }
}
