package lc191NumberOf1Bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void hammingWeight() {
        assertEquals(3, solution.hammingWeight(11));
        assertEquals(1, solution.hammingWeight(4));
        assertEquals(31, solution.hammingWeight(Integer.MAX_VALUE));
    }
}