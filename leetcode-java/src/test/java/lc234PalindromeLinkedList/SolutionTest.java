package lc234PalindromeLinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isPalindrome() {
        assertTrue(solution.isPalindrome(newList(new int[]{1})));
        assertTrue(solution.isPalindrome(newList(new int[]{1,1,})));
        assertTrue(solution.isPalindrome(newList(new int[]{1,0,1})));
        assertTrue(solution.isPalindrome(newList(new int[]{1,2,2,1})));
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

}