package lcof48ZuiChangBuHanChongFuZiFuChuanDeZiZiFuChuan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }
}