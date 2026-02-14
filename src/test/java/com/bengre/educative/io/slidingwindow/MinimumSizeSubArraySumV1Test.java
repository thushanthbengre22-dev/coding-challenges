package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinimumSizeSubArraySumV1Test {

    private MinimumSizeSubArraySumV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MinimumSizeSubArraySumV1();
    }

    @Test
    @DisplayName("Should find min length in standard case")
    void testStandardCase() {
        // [2, 3, 1, 2, 4, 3], target=7 -> [4, 3] is length 2
        int[] nums = {2, 3, 1, 2, 4, 3};
        assertEquals(2, solver.minSubArrayLen(7, nums));
    }

    @Test
    @DisplayName("Should handle case where a single element meets target")
    void testSingleElementMeetsTarget() {
        // [1, 10, 2, 3], target=9 -> [10] is length 1
        int[] nums = {1, 10, 2, 3};
        assertEquals(1, solver.minSubArrayLen(9, nums));
    }

    @Test
    @DisplayName("Should return 0 when target is never reached")
    void testTargetNotReached() {
        // [1, 1, 1, 1], target=10 -> Impossible
        int[] nums = {1, 1, 1, 1};
        assertEquals(0, solver.minSubArrayLen(10, nums));
    }

    @Test
    @DisplayName("Should handle case where the whole array is the solution")
    void testEntireArrayNeeded() {
        // [1, 2, 3, 4], target=10 -> [1, 2, 3, 4] is length 4
        int[] nums = {1, 2, 3, 4};
        assertEquals(4, solver.minSubArrayLen(10, nums));
    }

    @Test
    @DisplayName("Should handle duplicate numbers effectively")
    void testDuplicates() {
        // [1, 2, 2, 2, 1], target=4 -> [2, 2] is length 2
        int[] nums = {1, 2, 2, 2, 1};
        assertEquals(2, solver.minSubArrayLen(4, nums));
    }
}
