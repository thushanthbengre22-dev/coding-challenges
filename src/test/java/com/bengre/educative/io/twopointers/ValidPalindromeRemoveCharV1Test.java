package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindromeRemoveCharV1Test {

    private final ValidPalindromeRemoveCharV1 solver = new ValidPalindromeRemoveCharV1();

    @Test
    @DisplayName("Should return true for strings that are already palindromes")
    void testAlreadyPalindrome() {
        assertTrue(solver.isPalindrome("aba"));
        assertTrue(solver.isPalindrome("racecar"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abca", "deeee", "raceacar", "abbca"})
    @DisplayName("Should return true when removing ONE character makes it a palindrome")
    void testOneCharacterRemoval(String input) {
        // "abca" -> remove 'b' or 'c'
        // "deeee" -> remove 'd'
        assertTrue(solver.isPalindrome(input), "Failed for valid case: " + input);
    }

    @Test
    @DisplayName("Should return false when removing one character is NOT enough")
    void testInvalidCases() {
        assertFalse(solver.isPalindrome("abcde"), "Too many distinct characters");
        assertFalse(solver.isPalindrome("abcdefg"));
    }

    @Test
    @DisplayName("Should handle very small strings")
    void testEdgeCases() {
        assertTrue(solver.isPalindrome("a"), "Single char is always true");
        assertTrue(solver.isPalindrome("ab"), "Can remove 'a' or 'b' to make it true");
        assertTrue(solver.isPalindrome(""), "Empty string is technically true");
    }


}
