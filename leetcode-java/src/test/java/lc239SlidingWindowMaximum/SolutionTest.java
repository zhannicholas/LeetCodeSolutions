package lc239SlidingWindowMaximum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSlidingWindow() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{3,3,5,5,6,7}, solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        assertArrayEquals(new int[]{1}, solution.maxSlidingWindow(new int[]{1}, 1));
        assertArrayEquals(new int[]{1, -1}, solution.maxSlidingWindow(new int[]{1, -1}, 1));
        assertArrayEquals(new int[]{11}, solution.maxSlidingWindow(new int[]{9, 11}, 2));
    }
}