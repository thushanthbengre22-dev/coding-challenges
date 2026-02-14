package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringV1Test {

    private LongestSubstringV1 finder;

    @BeforeEach
    void setUp() {
        finder = new LongestSubstringV1();
    }

    @Test
    @DisplayName("Should find length for a standard string with repeats")
    void testStandardString() {
        // "abcabcbb" -> "abc" is length 3
        assertEquals(3, finder.findLongestSubstring("abcabcbb"));
    }

    @Test
    @DisplayName("Should find length when all characters are the same")
    void testAllSameCharacters() {
        // "bbbbb" -> "b" is length 1
        assertEquals(1, finder.findLongestSubstring("bbbbb"));
    }

    @Test
    @DisplayName("Should find length when no characters repeat")
    void testNoRepeats() {
        // "abcdef" -> length 6
        assertEquals(6, finder.findLongestSubstring("abcdef"));
    }

    @Test
    @DisplayName("Should handle spaces and digits")
    void testMixedCharacters() {
        // "pwwkew 121" -> "kew 12" is the longest (6)
        assertEquals(6, finder.findLongestSubstring("pwwkew 121"));
    }

    @Test
    @DisplayName("Should handle a single character string")
    void testSingleCharacter() {
        assertEquals(1, finder.findLongestSubstring("a"));
    }

    @Test
    @DisplayName("Should handle strings with repeated characters at the end")
    void testRepeatsAtEnd() {
        // "dvdf" -> "vdf" is length 3
        assertEquals(3, finder.findLongestSubstring("dvdf"));
    }
}
