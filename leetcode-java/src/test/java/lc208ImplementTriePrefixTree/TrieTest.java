package lc208ImplementTriePrefixTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    @Test
    void trieTest() {
        Trie root = new Trie();
        root.insert("apple");
        assertTrue(root.search("apple"));
        assertFalse(root.search("app"));
        assertTrue(root.startsWith("app"));
        root.insert("app");
        assertTrue(root.search("app"));
    }

}