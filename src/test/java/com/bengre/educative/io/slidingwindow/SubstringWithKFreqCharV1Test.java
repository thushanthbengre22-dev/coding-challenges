package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubstringWithKFreqCharV1Test {

    private SubstringWithKFreqCharV1 solver;

    @BeforeEach
    void setUp() {
        solver = new SubstringWithKFreqCharV1();
    }

    @Test
    @DisplayName("Should count substrings where at least one char appears k times")
    void testStandardCase() {
        // s = "abacaba", k = 3
        // Character 'a' appears 3 times.
        // The first window to satisfy this is "abaca" (indices 0 to 4).
        // If "abaca" is valid, then "abacab" and "abacaba" are also valid.
        String s = "abacaba";
        int k = 3;
        assertEquals(5, solver.numberOfSubstrings(s, k));
    }

    @Test
    @DisplayName("Should return 0 when no character can reach k frequency")
    void testImpossibleK() {
        String s = "abcde";
        int k = 2; // All chars are unique
        assertEquals(0, solver.numberOfSubstrings(s, k));
    }

    @Test
    @DisplayName("Should handle k = 1 (Every non-empty substring is valid)")
    void testKEqualsOne() {
        // For length 3, total substrings = (3 * 4) / 2 = 6
        String s = "abc";
        int k = 1;
        assertEquals(6, solver.numberOfSubstrings(s, k));
    }

    @Test
    @DisplayName("Should work with small strings and high k")
    void testHighK() {
        String s = "aaaaa";
        int k = 3;
        // Substrings with at least 3 'a's:
        // Length 3: "aaa" (3), Length 4: "aaaa" (2), Length 5: "aaaaa" (1)
        // Total = 6
        assertEquals(6, solver.numberOfSubstrings(s, k));
    }
}
