package lcof06CongWeiDaoTouDaYinLianBiao;

/*
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


限制：

0 <= 链表长度 <= 10000
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int[] ans = new int[length];
        int i = length - 1;
        while (head != null) {
            ans[i--] = head.val;
            head = head.next;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;
}
