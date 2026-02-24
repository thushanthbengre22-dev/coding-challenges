package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestRepeatingCharV1Test {

    private LongestRepeatingCharV1 finder;

    @BeforeEach
    void setUp() {
        finder = new LongestRepeatingCharV1();
    }

    @Test
    @DisplayName("Should find longest substring by replacing k characters")
    void testStandardReplacement() {
        // "AABABBA", k=1 -> "AAAABBA" (length 4)
        assertEquals(4, finder.longestRepeatingCharacterReplacement("AABABBA", 1));
    }

    @Test
    @DisplayName("Should handle k larger than the number of differing characters")
    void testHighKValue() {
        // "ABAB", k=2 -> "AAAA" or "BBBB" (length 4)
        assertEquals(4, finder.longestRepeatingCharacterReplacement("ABAB", 2));
    }

    @Test
    @DisplayName("Should return string length if k allows replacing everything")
    void testKEqualsLength() {
        assertEquals(5, finder.longestRepeatingCharacterReplacement("ABCDE", 5));
    }

    @Test
    @DisplayName("Should work when k is zero (find longest existing repeat)")
    void testZeroK() {
        // "AAABBC", k=0 -> "AAA" (length 3)
        assertEquals(3, finder.longestRepeatingCharacterReplacement("AAABBC", 0));
    }

    @Test
    @DisplayName("Should handle a single character string with k=0")
    void testSingleCharZeroK() {
        assertEquals(1, finder.longestRepeatingCharacterReplacement("A", 0));
    }

    @Test
    @DisplayName("Should find longest substring at the end of the string")
    void testReplacementAtEnd() {
        // "BAAAB", k=2 -> "AAAAA" (length 5)
        assertEquals(5, finder.longestRepeatingCharacterReplacement("BAAAB", 2));
    }
}
