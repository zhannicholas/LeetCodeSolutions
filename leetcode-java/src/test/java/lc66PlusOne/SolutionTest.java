package lc66PlusOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void plusOne() {
        assertArrayEquals(new int[]{1}, solution.plusOne(new int[]{0}));
        assertArrayEquals(new int[]{1,2,4}, solution.plusOne(new int[]{1,2,3}));
        assertArrayEquals(new int[]{1,0,0}, solution.plusOne(new int[]{9,9}));
    }
}