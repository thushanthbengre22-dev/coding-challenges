package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeV1Test {

    private final ValidPalindromeV1 solver = new ValidPalindromeV1();

    @Test
    @DisplayName("Should return true for a simple palindrome")
    void testSimplePalindrome() {
        assertTrue(solver.isPalindrome("racecar"), "Failed on simple palindrome 'racecar'");
    }

    @Test
    @DisplayName("Should ignore casing and non-alphanumeric characters")
    void testComplexPalindrome() {
        // "A man, a plan, a canal: Panama" is a classic LeetCode case
        String input = "A man, a plan, a canal: Panama";
        assertTrue(solver.isPalindrome(input), "Failed to ignore casing or punctuation");
    }

    @Test
    @DisplayName("Should return false for non-palindromes")
    void testNonPalindrome() {
        assertFalse(solver.isPalindrome("hello"), "'hello' is not a palindrome");
    }

    @Test
    @DisplayName("Should handle empty or single character strings")
    void testEdgeCases() {
        assertTrue(solver.isPalindrome(" "), "Empty string should be true");
        assertTrue(solver.isPalindrome("a"), "Single character should be true");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Madam", "Step on no pets", "Was it a car or a cat I saw?"})
    @DisplayName("Parameterized check for multiple palindromes")
    void testMultiplePalindromes(String candidate) {
        assertTrue(solver.isPalindrome(candidate));
    }
}