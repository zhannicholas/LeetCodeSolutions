package lc424LongestRepeatingCharacterReplacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void characterReplacement() {
        Solution solution = new Solution();
        assertEquals(4, solution.characterReplacement("AAAA", 2));
        assertEquals(4, solution.characterReplacement("ABAB", 2));
        assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }
}