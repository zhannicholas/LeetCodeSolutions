package lc8StringToIntegerAtoi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void myAtoi() {
        assertEquals(42, solution.myAtoi("42"));
        assertEquals(-42, solution.myAtoi("     -42"));
        assertEquals(4193, solution.myAtoi("4193 with words"));
        assertEquals(0, solution.myAtoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, solution.myAtoi("-91283472332"));
    }
}