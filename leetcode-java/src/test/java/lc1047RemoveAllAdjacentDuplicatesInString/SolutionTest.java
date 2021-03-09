package lc1047RemoveAllAdjacentDuplicatesInString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void removeDuplicates() {
        assertEquals("ca", solution.removeDuplicates("abbaca"));
    }
}