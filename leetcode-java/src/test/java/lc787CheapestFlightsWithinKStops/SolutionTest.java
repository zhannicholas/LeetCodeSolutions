package lc787CheapestFlightsWithinKStops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findCheapestPrice() {
        Solution solution = new Solution();
        assertEquals(7, solution.findCheapestPrice(5, new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}},0,2,2));
        assertEquals(5, solution.findCheapestPrice(5, new int[][]{{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}}, 0, 4, 1));
        assertEquals(200, solution.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        assertEquals(500, solution.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
    }
}