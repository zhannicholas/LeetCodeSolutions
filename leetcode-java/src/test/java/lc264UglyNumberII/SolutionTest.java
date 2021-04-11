package lc264UglyNumberII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void nthUglyNumber() {
        assertEquals(1, solution.nthUglyNumber(1));
        assertEquals(12, solution.nthUglyNumber(10));
    }
}