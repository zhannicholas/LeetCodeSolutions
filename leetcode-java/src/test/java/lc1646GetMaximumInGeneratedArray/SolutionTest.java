package lc1646GetMaximumInGeneratedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getMaximumGenerated() {
        Solution solution = new Solution();
        assertEquals(3, solution.getMaximumGenerated(7));
        assertEquals(1, solution.getMaximumGenerated(2));
        assertEquals(2, solution.getMaximumGenerated(3));
    }
}