package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidWordAbbreviationV1Test {

    private final ValidWordAbbreviationV1 solver = new ValidWordAbbreviationV1();

    @Test
    @DisplayName("Should return true for valid abbreviations (Standard Cases)")
    void testValidAbbreviations() {
        assertTrue(solver.validWordAbbreviation("internationalization", "i18n"));
        assertTrue(solver.validWordAbbreviation("calendar", "cal3ar"));
        assertTrue(solver.validWordAbbreviation("calendar", "c6r"));
        assertTrue(solver.validWordAbbreviation("apple", "a2le"));
    }

    @Test
    @DisplayName("Should return false for abbreviations with leading zeros")
    void testLeadingZeros() {
        // "c06r" is invalid even if the math (1+06+1 = 8) adds up.
        assertFalse(solver.validWordAbbreviation("calendar", "c06r"));
        assertFalse(solver.validWordAbbreviation("apple", "a03e"));
    }

    @Test
    @DisplayName("Should return false for non-matching characters")
    void testCharacterMismatch() {
        assertFalse(solver.validWordAbbreviation("calendar", "cal3as"), "Last character 'r' vs 's' mismatch");
        assertFalse(solver.validWordAbbreviation("apple", "a2b"));
    }

    @Test
    @DisplayName("Should return false if length exceeds word length")
    void testLengthOverflow() {
        assertFalse(solver.validWordAbbreviation("apple", "a5")); // a + 5 = 6 (Apple is 5)
        assertFalse(solver.validWordAbbreviation("calendar", "10")); // 10 > 8
    }

    @Test
    @DisplayName("Should return false if abbreviation is shorter than required")
    void testLengthUnderflow() {
        assertFalse(solver.validWordAbbreviation("apple", "a2")); // Only accounts for 3 chars
    }

    @Test
    @DisplayName("Should handle edge cases (single chars and empty)")
    void testEdgeCases() {
        assertTrue(solver.validWordAbbreviation("a", "1"));
        assertTrue(solver.validWordAbbreviation("a", "a"));
        assertFalse(solver.validWordAbbreviation("a", "2"));
    }


}
