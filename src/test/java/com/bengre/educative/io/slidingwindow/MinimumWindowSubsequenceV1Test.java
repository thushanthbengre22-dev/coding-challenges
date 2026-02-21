package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumWindowSubsequenceV1Test {

    private MinimumWindowSubsequenceV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MinimumWindowSubsequenceV1();
    }

    @Test
    @DisplayName("Should find the shortest subsequence window in a standard string")
    void testStandardCase() {
        // s1 = "abcdebdde", s2 = "bde"
        // Possible windows: "bcde" (len 4), "bdde" (len 4), "be" (no, 'd' is missing)
        // Both "bcde" and "bdde" are length 4. Return the leftmost one.
        String s1 = "abcdebdde";
        String s2 = "bde";
        assertEquals("bcde", solver.minWindow(s1, s2));
    }

    @Test
    @DisplayName("Should return empty string when subsequence cannot be formed")
    void testNoMatch() {
        String s1 = "afge";
        String s2 = "abc";
        assertEquals("", solver.minWindow(s1, s2));
    }

    @Test
    @DisplayName("Should respect the order of characters in s2")
    void testOrderRequirement() {
        // s1 contains 'a', 'c', 'b' but not in that order.
        String s1 = "acba";
        String s2 = "abc";
        assertEquals("", solver.minWindow(s1, s2));
    }

    @Test
    @DisplayName("Should handle very long s1 and short s2")
    void testLongS1() {
        String s1 = "fgaabbccddeeffgghh";
        String s2 = "ace";
        assertEquals("abbccdde", solver.minWindow(s1, s2));
    }

    @Test
    @DisplayName("Should return exact match if s1 and s2 are same")
    void testExactMatch() {
        assertEquals("abc", solver.minWindow("abc", "abc"));
    }
}
