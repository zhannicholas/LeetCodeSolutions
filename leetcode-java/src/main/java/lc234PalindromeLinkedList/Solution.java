package lc234PalindromeLinkedList;

/*
234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution {
    /**
     * 快慢指针找出中间节点 -> 反转后半部分 -> 比较
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (slow.next == null) {    // 只有一个节点
            return true;
        }
        ListNode part2Head = slow.next;
        slow.next = null;   // 断开
        // 反转 part2Head 及其后继节点
        ListNode cur = part2Head.next, next;
        part2Head.next = null;  // 这个节点在反转后应该是最后一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = part2Head;
            part2Head = cur;
            cur = next;
        }

        while (head != null && part2Head != null) {
            if (head.val != part2Head.val) {
                return false;
            }
            head = head.next;
            part2Head = part2Head.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
