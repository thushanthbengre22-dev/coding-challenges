package com.bengre.educative.io.fastslowpointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircularArrayLoopV1Test {

    private CircularArrayLoopV1 detector;

    @BeforeEach
    void setUp() {
        detector = new CircularArrayLoopV1();
    }

    @Test
    @DisplayName("Should return true for a valid forward cycle")
    void testValidForwardCycle() {
        // Index 0 -> 2, Index 2 -> 3, Index 3 -> 0
        // All values (2, 1, 2) are positive
        int[] nums = {2, -1, 1, 2, 2};
        assertTrue(detector.circularArrayLoop(nums));
    }

    @Test
    @DisplayName("Should return true for a valid backward cycle")
    void testValidBackwardCycle() {
        // All values are negative and lead back to the start
        int[] nums = {-2, -1, -2, -2};
        assertTrue(detector.circularArrayLoop(nums));
    }

    @Test
    @DisplayName("Should handle negative steps that wrap around the front")
    void testNegativeWrapAround() {
        // -1 at index 0 takes you to the last index.
        int[] nums = {-1, 2};
        assertFalse(detector.circularArrayLoop(nums));
    }
}
