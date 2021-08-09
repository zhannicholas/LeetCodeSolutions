package lc904FruitIntoBaskets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void totalFruit() {
        Solution solution = new Solution();
        assertEquals(5, solution.totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
        assertEquals(3, solution.totalFruit(new int[]{1,2,2}));
        assertEquals(3, solution.totalFruit(new int[]{0, 1,2,2}));
        assertEquals(4, solution.totalFruit(new int[]{1,2,3,2,2}));
        assertEquals(5, solution.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}