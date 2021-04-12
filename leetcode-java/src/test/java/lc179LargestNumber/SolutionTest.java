package lc179LargestNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void largestNumber() {
        assertEquals("343234323", solution.largestNumber(new int[]{34323,3432}));
        assertEquals("1113111311", solution.largestNumber(new int[]{111311,1113}));
        assertEquals("210", solution.largestNumber(new int[]{10,2}));
        assertEquals("9534330", solution.largestNumber(new int[]{3,30,34,5,9}));
        assertEquals("1", solution.largestNumber(new int[]{1}));
        assertEquals("10", solution.largestNumber(new int[]{10}));
    }
}