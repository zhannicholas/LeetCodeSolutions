package lc447NumberOfBoomerangs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void numberOfBoomerangs() {
        Solution solution = new Solution();
        assertEquals(2, solution.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
        assertEquals(2, solution.numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}));
        assertEquals(0, solution.numberOfBoomerangs(new int[][]{{1,1}}));
    }

}