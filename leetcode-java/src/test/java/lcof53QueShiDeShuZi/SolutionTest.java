package lcof53QueShiDeShuZi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void missingNumber() {
        Solution solution = new Solution();
        assertEquals(1, solution.missingNumber(new int[]{0}));
        assertEquals(2, solution.missingNumber(new int[]{0,1}));
        assertEquals(3, solution.missingNumber(new int[]{0,1,2,4}));
    }
}