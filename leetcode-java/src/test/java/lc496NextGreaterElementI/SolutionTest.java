package lc496NextGreaterElementI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nextGreaterElement() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{-1,-1,-1,-1,-1}, solution.nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{5,4,3,2,1}));
    }
}