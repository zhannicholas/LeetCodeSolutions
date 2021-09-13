package lcof58IFanZhuanDanCiShuXu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseWords() {
        Solution solution = new Solution();
        assertEquals("world! hello", solution.reverseWords("  hello world!  "));
        assertEquals("example good a", solution.reverseWords("a good   example"));
    }
}