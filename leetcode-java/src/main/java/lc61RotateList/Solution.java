package lc61RotateList;

/*
61. 旋转链表
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/
public class Solution {
    /**
     * 两次遍历。第一次获取链表长度（因为 k 可能大于链表长度），然后使用双指针将链表切分为两段，交换两段位置重新拼接即可达到目的。
     * 注意边界情况的处理
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        ListNode cur = dummy;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        ListNode last = cur;

        int part2Len = k % len;
        // 处理边界情况
        if (part2Len == 0) {
            return head;
        }
        int part1Len = len - part2Len;
        len = 0;
        cur = dummy;
        while (len < part1Len) {
            len++;
            cur = cur.next;
        }

        // 重新拼接
        dummy.next = cur.next;
        last.next = head;
        cur.next = null;

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
