package lc209MinimumSizeSubarraySum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minSubArrayLen() {
        Solution solution = new Solution();
        assertEquals(3, solution.minSubArrayLen(11, new int[]{1,2,3,4,5}));
        assertEquals(2, solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        assertEquals(1, solution.minSubArrayLen(4, new int[]{1,4,4}));
        assertEquals(0, solution.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1}));
    }
}