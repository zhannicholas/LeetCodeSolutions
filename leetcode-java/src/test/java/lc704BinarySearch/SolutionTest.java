package lc704BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void search() {
        assertEquals(4, solution.search(new int[]{-1,0,3,5,9,12}, 9));
        assertEquals(-1, solution.search(new int[]{-1,0,3,5,9,12}, 2));
    }
}