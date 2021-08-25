package lc1410HtmlEntityParser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void entityParser() {
        Solution solution = new Solution();
        assertEquals("&>", solution.entityParser("&&gt;"));
        assertEquals("& is an HTML entity but &ambassador; is not.", solution.entityParser("&amp; is an HTML entity but &ambassador; is not."));
        assertEquals("and I quote: \"...\"", solution.entityParser("and I quote: &quot;...&quot;"));
        assertEquals("Stay home! Practice on Leetcode :)", solution.entityParser("Stay home! Practice on Leetcode :)"));
        assertEquals("x > y && x < y is always false", solution.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
        assertEquals("leetcode.com/problemset/all", solution.entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }
}