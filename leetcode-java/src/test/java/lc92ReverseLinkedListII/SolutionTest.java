package lc92ReverseLinkedListII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void reverseBetween() {
        assertArrayEquals(new Integer[]{1,4,3,2,5}, traverseList(solution.reverseBetween(newList(new int[]{1,2,3,4,5}), 2, 4)));
    }

    private Integer[] traverseList(Solution.ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        return vals.toArray(new Integer[]{});
    }

    private Solution.ListNode newList(int[] vals) {
        if (vals == null) {
            return null;
        }
        Solution.ListNode dummy = new Solution.ListNode(-1);
        Solution.ListNode cur = dummy;
        for (int val: vals) {
            cur.next = new Solution.ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }
}