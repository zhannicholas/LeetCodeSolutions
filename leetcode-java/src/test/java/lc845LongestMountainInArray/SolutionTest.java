package lc845LongestMountainInArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestMountain() {
        Solution solution = new Solution();
        assertEquals(0, solution.longestMountain(new int[]{0,2,2}));
        assertEquals(4, solution.longestMountain(new int[]{875,884,239,731,723,685}));
        assertEquals(0, solution.longestMountain(new int[]{1,2,3,4}));
        assertEquals(0, solution.longestMountain(new int[]{2,2,2}));
        assertEquals(3, solution.longestMountain(new int[]{1,2,1}));
        assertEquals(5, solution.longestMountain(new int[]{2,1,4,7,3,2,5}));
    }
}