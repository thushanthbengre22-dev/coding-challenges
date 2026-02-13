package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountFixedBoundSubarraysV1Test {

    private final CountFixedBoundSubarraysV1 solver = new CountFixedBoundSubarraysV1();

    @Test
    @DisplayName("Should count multiple overlapping valid subarrays")
    void testStandardCase() {
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1, maxK = 5;
        // Valid subarrays: [1,3,5], [1,3,5,2]
        // Note: [1,3,5,2,7] is invalid because 7 > maxK.
        assertEquals(2, solver.countSubarrays(nums, minK, maxK));
    }

    @Test
    @DisplayName("Should handle cases where minK and maxK are the same")
    void testSameMinMax() {
        int[] nums = {1, 1, 1, 1};
        int minK = 1, maxK = 1;
        // All subarrays are valid: [1], [1], [1], [1], [1,1], [1,1], [1,1], [1,1,1], [1,1,1], [1,1,1,1]
        // Total = n * (n + 1) / 2 = 10
        assertEquals(10, solver.countSubarrays(nums, minK, maxK));
    }

    @Test
    @DisplayName("Should return 0 when bounds are never met")
    void testNoBoundsMet() {
        int[] nums = {1, 2, 3, 4};
        int minK = 1, maxK = 5; // 5 is never present
        assertEquals(0, solver.countSubarrays(nums, minK, maxK));
    }

    @Test
    @DisplayName("Should reset count when an out-of-bounds element is encountered")
    void testOutOfBoundsReset() {
        int[] nums = {1, 3, 5, 10, 1, 3, 5};
        int minK = 1, maxK = 5;
        // Two separate areas: [1,3,5] before the 10, and [1,3,5] after.
        assertEquals(2, solver.countSubarrays(nums, minK, maxK));
    }
}
