package lc354RussianDollEnvelopes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void maxEnvelopes_dp() {
        assertEquals(5, solution.maxEnvelopes_dp(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
        assertEquals(3, solution.maxEnvelopes_dp(new int[][]{{5,4}, {6,4}, {6,7}, {2,3}}));
        assertEquals(1, solution.maxEnvelopes_dp(new int[][]{{1,1}, {1,1}, {1,1}}));
    }
}