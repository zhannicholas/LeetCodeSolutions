package lc55JumpGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canJump() {
        Solution solution = new Solution();
        assertTrue(solution.canJump(new int[]{1,2,0,0}));
        assertTrue(solution.canJump(new int[]{2,0,0}));
        assertTrue(solution.canJump(new int[]{2,3,1,1,4}));
        assertFalse(solution.canJump(new int[]{3,2,1,0,4}));
    }
}