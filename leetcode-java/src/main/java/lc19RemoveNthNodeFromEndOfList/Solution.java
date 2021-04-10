package lc19RemoveNthNodeFromEndOfList;

/*
19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        // fast 先走 n 步
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 同步推进，直到 fast 指向最后一个节点，slow 的下一个节点就是要删除的那个
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
