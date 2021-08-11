package lc918MaximumSumCircularSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSubarraySumCircular() {
        Solution solution = new Solution();

        assertEquals(3, solution.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        assertEquals(10, solution.maxSubarraySumCircular(new int[]{5,-3,5}));
        assertEquals(4, solution.maxSubarraySumCircular(new int[]{3,-1,2,-1}));
        assertEquals(3, solution.maxSubarraySumCircular(new int[]{3,-2,2,-3}));
        assertEquals(-1, solution.maxSubarraySumCircular(new int[]{-2,-3,-1}));
    }
}