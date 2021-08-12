package lc322CoinChange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void coinChange() {
        Solution solution = new Solution();
        assertEquals(3, solution.coinChange(new int[]{1,2,5}, 11));
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
        assertEquals(1, solution.coinChange(new int[]{1}, 1));
    }
}