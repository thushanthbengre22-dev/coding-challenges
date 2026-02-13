package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StrobogrammaticNumberV1Test {

    private final StrobogrammaticNumberV1 solver = new StrobogrammaticNumberV1();

    @ParameterizedTest
    @ValueSource(strings = {"69", "88", "818", "609", "101", "0"})
    @DisplayName("Should return true for valid strobogrammatic numbers")
    void testValidStrobogrammatic(String input) {
        assertTrue(solver.isStrobogrammatic(input), "Failed for valid input: " + input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"962", "2", "3", "4", "5", "7"})
    @DisplayName("Should return false for digits that cannot be rotated")
    void testInvalidDigits(String input) {
        assertFalse(solver.isStrobogrammatic(input), "Digits like 2,3,4,5,7 are not flippable");
    }

    @Test
    @DisplayName("Should return false for valid digits in wrong positions")
    void testMismatchedPairs() {
        // 6 rotated is 9, so "66" upside down is "99", not "66"
        assertFalse(solver.isStrobogrammatic("66"));
        assertFalse(solver.isStrobogrammatic("99"));
        assertFalse(solver.isStrobogrammatic("618"));
    }

    @Test
    @DisplayName("Should handle single-digit edge cases")
    void testSingleDigits() {
        assertTrue(solver.isStrobogrammatic("1"));
        assertTrue(solver.isStrobogrammatic("8"));
        assertTrue(solver.isStrobogrammatic("0"));
    }
}
