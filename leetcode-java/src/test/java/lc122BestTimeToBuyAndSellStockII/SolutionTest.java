package lc122BestTimeToBuyAndSellStockII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void maxProfit() {
        assertEquals(7, solution.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, solution.maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, solution.maxProfit(new int[]{5,4,3,2,1}));
    }
}