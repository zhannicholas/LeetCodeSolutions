package lc881BoatsToSavePeople;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numRescueBoats() {
        Solution solution = new Solution();
        assertEquals(3, solution.numRescueBoats(new int[]{3,2,3,2,2},6));
        assertEquals(1, solution.numRescueBoats(new int[]{1,2}, 3));
        assertEquals(3, solution.numRescueBoats(new int[]{3,2,2,1},3));
        assertEquals(4, solution.numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}