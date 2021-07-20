package lc557ReverseWordsInAStringIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverseWords() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", solution.reverseWords("Let's take LeetCode contest"));
        assertEquals("cba", solution.reverseWords("abc"));
        assertEquals("a", solution.reverseWords("a"));
    }
}