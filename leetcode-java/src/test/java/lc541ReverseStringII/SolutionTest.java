package lc541ReverseStringII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseStr() {
        Solution solution = new Solution();
        assertEquals("gfedcba", solution.reverseStr("abcdefg", 8));
        assertEquals("dcba", solution.reverseStr("abcd", 4));
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2));
        assertEquals("bacd", solution.reverseStr("abcd", 2));
    }
}