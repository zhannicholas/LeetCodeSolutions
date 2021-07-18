package lc977SquaresOfASortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void sortedSquares() {
        assertArrayEquals(new int[]{0,1,9,16,100}, solution.sortedSquares(new int[]{-4,-1,0,3,10}));
        assertArrayEquals(new int[]{4,9,9,49,121}, solution.sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}