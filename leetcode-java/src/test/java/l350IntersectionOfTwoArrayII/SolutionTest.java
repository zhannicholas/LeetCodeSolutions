package l350IntersectionOfTwoArrayII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void intersect() {
        assertArrayEquals(new int[]{2,2}, solution.intersect(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{4,9}, solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }
}