package lc456123Pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void find132pattern() {
        assertTrue(solution.find132pattern(new int[]{3,5,0,3,4}));
        assertFalse(solution.find132pattern(new int[]{1,2,3,4}));
        assertTrue(solution.find132pattern(new int[]{3,1,4,2}));
        assertTrue(solution.find132pattern(new int[]{-1,3,2,0}));
    }
}