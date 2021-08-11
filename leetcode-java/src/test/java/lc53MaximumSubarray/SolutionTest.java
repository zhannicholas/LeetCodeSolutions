package lc53MaximumSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSubArray() {
        Solution solution = new Solution();
        assertEquals(6, solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(1, solution.maxSubArray(new int[]{1}));
        assertEquals(0, solution.maxSubArray(new int[]{0}));
        assertEquals(-100, solution.maxSubArray(new int[]{-100}));
    }
}