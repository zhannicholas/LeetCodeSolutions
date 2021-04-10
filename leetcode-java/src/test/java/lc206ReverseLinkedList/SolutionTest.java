package lc206ReverseLinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverseList() {
        assertArrayEquals(new Integer[]{5,4,3,2,1}, traverseList(solution.reverseList(newList(new int[]{1,2,3,4,5}))));
    }

    private Solution.ListNode newList(int[] nums) {
        Solution.ListNode dummy = new Solution.ListNode(-1);
        Solution.ListNode cur = dummy;
        for (int num: nums) {
            cur.next = new Solution.ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    private Integer[] traverseList(Solution.ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toArray(new Integer[]{});
    }
}