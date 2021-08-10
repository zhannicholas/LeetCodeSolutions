package lc435NonOverlappingIntervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void eraseOverlapIntervals() {
        Solution solution = new Solution();
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{5,7},{-100,-2}}));
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
    }
}