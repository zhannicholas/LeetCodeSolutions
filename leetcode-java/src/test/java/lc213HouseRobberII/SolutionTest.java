package lc213HouseRobberII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rob() {
        assertEquals(3, solution.rob(new int[]{2,3,2}));
        assertEquals(0, solution.rob(new int[]{0}));
        assertEquals(4, solution.rob(new int[]{1,2,3,1}));
    }
}