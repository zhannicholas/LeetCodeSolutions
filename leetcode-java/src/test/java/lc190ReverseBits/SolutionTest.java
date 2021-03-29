package lc190ReverseBits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverseBits() {
        assertEquals(964176192, solution.reverseBits(43261596));
    }
}