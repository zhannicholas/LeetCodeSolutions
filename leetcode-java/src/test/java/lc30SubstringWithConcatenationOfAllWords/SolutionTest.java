package lc30SubstringWithConcatenationOfAllWords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findSubstring() {
        Solution solution = new Solution();
        assertArrayEquals(new Integer[]{0,4,1,2,3}, solution.findSubstring("dddddddddddd", new String[]{"dddd", "dddd"}).toArray());
        assertArrayEquals(new Integer[]{0,9}, solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}).toArray());
        assertArrayEquals(new Integer[]{6,9,12}, solution.findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}).toArray());
        assertArrayEquals(new Integer[]{8}, solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}).toArray());
    }
}