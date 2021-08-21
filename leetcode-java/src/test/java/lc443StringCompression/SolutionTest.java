package lc443StringCompression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compress() {
        Solution solution = new Solution();
        char[] chars1 = new char[]{'a','a','b','b','c','c','c'};
        assertEquals(6, solution.compress(chars1));
        assertArrayEquals(new char[]{'a', '2', 'b', '2', 'c', '3', 'c'}, chars1);
    }
}