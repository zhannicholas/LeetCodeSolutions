package lc347TopKFrequentElements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void topKFrequent() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{1,2}, solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}