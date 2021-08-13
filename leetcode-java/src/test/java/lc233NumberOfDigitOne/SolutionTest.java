package lc233NumberOfDigitOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void countDigitOne() {
        Solution solution = new Solution();
        assertEquals(6, solution.countDigitOne(13));
        assertEquals(767944060, solution.countDigitOne(824883294));
    }
}