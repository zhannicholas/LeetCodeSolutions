package lc567PermutationInString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void checkInclusion() {
        Solution solution = new Solution();
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
    }
}