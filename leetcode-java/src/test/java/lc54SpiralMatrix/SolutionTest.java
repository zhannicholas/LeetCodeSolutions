package lc54SpiralMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void spiralOrder() {
        assertArrayEquals(new Integer[]{1,2,3,6,9,8,7,4,5}, solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1,2,3,4,8,12,11,10,9,5,6,7}, solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{1,2,3,6,9,12,11,10,7,4,5,8}, solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}}).toArray(new Integer[]{}));
    }


}