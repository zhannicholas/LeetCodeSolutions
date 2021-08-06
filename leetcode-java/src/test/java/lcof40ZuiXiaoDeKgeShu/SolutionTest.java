package lcof40ZuiXiaoDeKgeShu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getLeastNumbers() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{3,2,1}, solution.getLeastNumbers(new int[]{1,2,4,5,3}, 3));
    }
}