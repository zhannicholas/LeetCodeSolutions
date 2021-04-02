package lcci1721VolumeOfHistogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void trap() {
        assertEquals(2, solution.trap(new int[]{2,0,2}));
        assertEquals(6, solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}