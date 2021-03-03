package lc338CountingBits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void countBits_group() {
        assertArrayEquals(new int[]{0,1,1,2,1,2,2,3}, solution.countBits_group(7));
    }

    @Test
    void countBits_odd_even() {
        assertArrayEquals(new int[]{0,1,1,2,1,2,2,3}, solution.countBits_odd_even(7));
    }
}