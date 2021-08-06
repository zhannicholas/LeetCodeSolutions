package lc143ReorderList;

/*
143. 重排链表
给定一个单链表 L 的头节点 head ，单链表 L 表示为：

 L0 → L1 → … → Ln-1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例 1:



输入: head = [1,2,3,4]
输出: [1,4,2,3]
示例 2:



输入: head = [1,2,3,4,5]
输出: [1,5,2,4,3]


提示：

链表的长度范围为 [1, 5 * 10^4]
1 <= node.val <= 1000
 */
public class Solution {
    /**
     * 先将链表从中间节点断开（偶数个节点直接断开，奇数个节点中间节点归前一段），并逆序后一段。
     * 然后依次从两段中各取一个节点放入最后的链表，重复这个操作直到取完两端链表的所有节点。
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode[] nodes = splitList(head);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode n1 = nodes[0], n2 = reverse(nodes[1]);
        while (n1 != null && n2 != null) {
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
            cur.next = null;
        }
        if (n1 != null) {
            cur.next = n1;
        }

        head.next = dummy.next.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = dummy.next;
            ListNode newHead = head;
            head = head.next;
            dummy.next = newHead;
            newHead.next = next;
        }

        return dummy.next;
    }

    private ListNode[] splitList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, n1 = head, n2 = head;

        while (n2 != null && n2.next != null) {
            prev = n1;
            n1 = n1.next;
            n2 = n2.next.next;
        }

        // 当节点数量为偶数时，n1 就是后半段的头节点
        if (n2 == null) {
            prev.next = null;
            return new ListNode[]{head, n1};
        }
        // 当节点数量为奇数时，n1.next 是后半段的头节点
        ListNode[] ans = new ListNode[]{head, n1.next};
        n1.next = null;
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;
}
