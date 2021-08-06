package lc1642FurthestBuildingYouCanJump;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void furthestBuilding() {
        Solution solution = new Solution();
        assertEquals(4, solution.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
    }
}