package com.bengre.educative.io.fastslowpointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HappyNumberV1Test {

    private HappyNumberV1 detector;

    @BeforeEach
    void setUp() {
        detector = new HappyNumberV1();
    }

    @Test
    @DisplayName("Should return true for a known happy number (19)")
    void testHappyNumber() {
        // 19 -> 1^2 + 9^2 = 82
        // 82 -> 8^2 + 2^2 = 68
        // 68 -> 6^2 + 8^2 = 100
        // 100 -> 1^2 + 0^2 + 0^2 = 1
        assertTrue(detector.isHappyNumber(19), "19 should be a happy number");
    }

    @Test
    @DisplayName("Should return false for a known unhappy number (8)")
    void testUnhappyNumber() {
        // 8 eventually enters a cycle: 8, 64, 52, 29, 85, 89, 145, 42, 20, 4, 16, 37, 58, 89...
        assertFalse(detector.isHappyNumber(8), "8 should not be a happy number");
    }

    @Test
    @DisplayName("Should return true for the number 1")
    void testOne() {
        assertTrue(detector.isHappyNumber(1), "1 is the definition of a happy number");
    }

    @Test
    @DisplayName("Should return true for 7 (reaches 1 after several steps)")
    void testSeven() {
        // 7 -> 49 -> 97 -> 130 -> 10 -> 1
        assertTrue(detector.isHappyNumber(7), "7 should be a happy number");
    }

    @Test
    @DisplayName("Should handle the maximum constraint value")
    void testLargeNumber() {
        // 2^31 - 1 is 2147483647
        int n = Integer.MAX_VALUE;
        // This won't crash and will eventually find a cycle or 1
        assertDoesNotThrow(() -> detector.isHappyNumber(n));
    }
}
