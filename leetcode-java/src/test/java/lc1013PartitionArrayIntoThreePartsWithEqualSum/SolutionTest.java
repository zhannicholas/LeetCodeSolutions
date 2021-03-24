package lc1013PartitionArrayIntoThreePartsWithEqualSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void canThreePartsEqualSum() {
//        assertTrue(solution.canThreePartsEqualSum(new int[]{0,0,0,0}));
        assertFalse(solution.canThreePartsEqualSum(new int[]{1,-1,1,-1}));
        assertTrue(solution.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        assertFalse(solution.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        assertTrue(solution.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
}