package lc416PartitionEqualSubsetSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canPartition() {
        Solution solution = new Solution();
        assertTrue(solution.canPartition(new int[]{3,3,3,4,5}));
        assertFalse(solution.canPartition(new int[]{2,2,3,5}));
        assertTrue(solution.canPartition(new int[]{1,5,11,5}));
        assertFalse(solution.canPartition(new int[]{1,2,3,5}));
    }
}