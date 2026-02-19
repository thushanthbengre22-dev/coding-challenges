package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumWindowSubstringV1Test {

    private MinimumWindowSubstringV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MinimumWindowSubstringV1();
    }

    @Test
    @DisplayName("Should find the shortest window in a standard mixed string")
    void testStandardCase() {
        // s = "ADOBECODEBANC", t = "ABC"
        // Possible windows: "ADOBEC", "CODEBA", "BANC"
        // "BANC" is the shortest with length 4.
        assertEquals("BANC", solver.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    @DisplayName("Should return the entire string if it is the only match")
    void testExactMatch() {
        assertEquals("a", solver.minWindow("a", "a"));
    }

    @Test
    @DisplayName("Should return empty string if no window contains all characters")
    void testNoMatch() {
        assertEquals("", solver.minWindow("a", "aa"));
    }

    @Test
    @DisplayName("Should handle multiple characters of the same type")
    void testDuplicateRequirements() {
        // s = "aaabbbbbcba", t = "abc"
        // Shortest window is "cba" at the end
        assertEquals("cba", solver.minWindow("aaabbbbbcba", "abc"));
    }

    @Test
    @DisplayName("Should be case sensitive")
    void testCaseSensitivity() {
        // t requires 'A', s has 'a'. No match.
        assertEquals("", solver.minWindow("ab", "A"));
    }
}
