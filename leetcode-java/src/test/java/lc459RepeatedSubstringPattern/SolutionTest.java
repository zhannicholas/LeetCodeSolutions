package lc459RepeatedSubstringPattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void repeatedSubstringPattern() {
        Solution solution = new Solution();
        assertFalse(solution.repeatedSubstringPattern("abac"));
        assertTrue(solution.repeatedSubstringPattern(""));
        assertTrue(solution.repeatedSubstringPattern("a"));
        assertTrue(solution.repeatedSubstringPattern("aa"));
        assertTrue(solution.repeatedSubstringPattern("abab"));
        assertFalse(solution.repeatedSubstringPattern("aba"));
        assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
    }
}