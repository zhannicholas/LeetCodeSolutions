package lc42TrappingRainWater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void trap() {
        Solution solution = new Solution();
        assertEquals(96, solution.trap1(new int[]{7,4,2,0,0,6,4,4,1,9,8,6,0,0,4,8,9,8,0,8,3,5,2,4,9,8}));
        assertEquals(6, solution.trap1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, solution.trap1(new int[]{4,2,0,3,2,5}));
    }
}