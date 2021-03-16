package lc59SpiralMatrixII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void generateMatrix() {
        assertArrayEquals(new int[][]{{1}}, solution.generateMatrix(1));
        assertArrayEquals(new int[][]{{1,2,3},{8,9,4},{7,6,5}}, solution.generateMatrix(3));
    }
}