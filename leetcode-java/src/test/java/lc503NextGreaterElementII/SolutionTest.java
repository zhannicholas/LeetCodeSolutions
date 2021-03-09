package lc503NextGreaterElementII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void nextGreaterElements_brutal() {
        assertArrayEquals(new int[]{2, -1, 2}, solution.nextGreaterElements_brutal(new int[]{1, 2, 1}));
    }

    @Test
    void nextGreaterElements_monotonic_stack() {
        assertArrayEquals(new int[]{2, -1, 2}, solution.nextGreaterElements_monotonic_stack(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{5,5,5,6,-1,5}, solution.nextGreaterElements_monotonic_stack(new int[]{3,2,1,5,6,4}));
    }
}