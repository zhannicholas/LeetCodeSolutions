package lcof46BaShuZiFanYiChengZiFuChuan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void translateNum() {
        Solution solution = new Solution();
        assertEquals(5, solution.translateNum(12258));
    }
}