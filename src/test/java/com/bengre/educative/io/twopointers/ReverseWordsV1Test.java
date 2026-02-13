package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsV1Test {

    @Test
    @DisplayName("Should reverse words in a standard sentence")
    void testStandardSentence() {
        String input = "the sky is blue";
        String expected = "blue is sky the";
        assertEquals(expected, ReverseWordsV1.reverseWords(input));
    }

    @Test
    @DisplayName("Should handle multiple spaces and trailing/leading whitespace")
    void testComplexSpaces() {
        // This checks if your while loops correctly skip extra spaces
        String input = "  hello world  ";
        String expected = "world hello";
        assertEquals(expected, ReverseWordsV1.reverseWords(input));
    }

    @Test
    @DisplayName("Should handle a single word")
    void testSingleWord() {
        String input = "Java";
        String expected = "Java";
        assertEquals(expected, ReverseWordsV1.reverseWords(input));
    }
}