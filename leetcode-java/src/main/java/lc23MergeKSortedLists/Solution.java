package lc23MergeKSortedLists;

import java.util.PriorityQueue;
import java.util.Queue;

/*
23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。



示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */
public class Solution {
    /**
     * 使用优先队列进行合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 小的元素放队头
        Queue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node: lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        // 出队形成新链表
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            cur.next = null;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
}
