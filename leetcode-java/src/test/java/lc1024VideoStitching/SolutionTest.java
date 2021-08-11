package lc1024VideoStitching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void videoStitching() {
        Solution solution = new Solution();
        assertEquals(3, solution.videoStitching(new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}},9));
        assertEquals(3, solution.videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10));
        assertEquals(-1, solution.videoStitching(new int[][]{{0,1},{1,2}}, 5));
        assertEquals(-1, solution.videoStitching(new int[][]{{1,3}}, 2));

    }
}