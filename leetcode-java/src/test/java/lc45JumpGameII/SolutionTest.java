package lc45JumpGameII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void jump() {
        Solution solution = new Solution();
        assertEquals(1, solution.jump(new int[]{2,1}));
        assertEquals(0, solution.jump(new int[]{0}));
        assertEquals(2, solution.jump(new int[]{2,3,1,1,4}));
        assertEquals(2, solution.jump(new int[]{2,3,0,1,4}));
    }
}