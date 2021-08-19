package lc345ReverseVowelsOfAString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseVowels() {
        Solution solution = new Solution();
        assertEquals("holle", solution.reverseVowels("hello"));
    }
}