package lc240SearchA2dMatrixII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchMatrix() {
        Solution solution = new Solution();
        assertTrue(solution.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        assertTrue(solution.searchMatrix(new int[][]{{1},{2},{3},{4},{5}}, 2));
    }
}