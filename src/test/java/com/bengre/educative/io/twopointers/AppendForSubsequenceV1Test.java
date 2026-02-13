package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppendForSubsequenceV1Test {

    private final AppendForSubsequenceV1 solver = new AppendForSubsequenceV1();

    @Test
    @DisplayName("Should return 0 if target is already a subsequence")
    void testAlreadySubsequence() {
        assertEquals(0, solver.appendCharacters("abcde", "ace"));
        assertEquals(0, solver.appendCharacters("abc", "abc"));
    }

    @Test
    @DisplayName("Should return full length of target if no characters match")
    void testNoMatch() {
        assertEquals(3, solver.appendCharacters("abc", "def"));
    }

    @Test
    @DisplayName("Should return remaining characters needed after partial match")
    void testPartialMatch() {
        // "co" is found in "coach", "de" needs to be appended.
        assertEquals(2, solver.appendCharacters("coach", "code"));

        // "a" is found, "z" needs to be appended.
        assertEquals(1, solver.appendCharacters("ab", "az"));
    }

    @Test
    @DisplayName("Should handle single character strings")
    void testSingleChars() {
        assertEquals(0, solver.appendCharacters("a", "a"));
        assertEquals(1, solver.appendCharacters("a", "b"));
    }
}
