package lc84LargestRectangleInHistogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void largestRectangleArea() {
        Solution solution = new Solution();
        assertEquals(2, solution.largestRectangleArea(new int[]{1,1}));
        assertEquals(1, solution.largestRectangleArea(new int[]{1}));
        assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        assertEquals(4, solution.largestRectangleArea(new int[]{2,4}));
    }
}