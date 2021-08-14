package lc1583CountUnhappyFriends;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void unhappyFriends() {
        Solution solution = new Solution();
        assertEquals(2, solution.unhappyFriends(4, new int[][]{{1,2,3},{3,2,0},{3,1,0},{1,2,0}}, new int[][]{{0,1},{2,3}}));
        assertEquals(0, solution.unhappyFriends(2, new int[][]{{1},{0}}, new int[][]{{1,0}}));
        assertEquals(4, solution.unhappyFriends(4, new int[][]{{1,3,2},{2,3,0},{1,3,0},{0,2,1}}, new int[][]{{1,3},{0,2}}));
    }
}