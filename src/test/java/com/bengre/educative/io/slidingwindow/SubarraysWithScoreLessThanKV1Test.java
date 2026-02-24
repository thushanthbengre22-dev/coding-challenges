package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubarraysWithScoreLessThanKV1Test {

    private SubarraysWithScoreLessThanKV1 solver;

    @BeforeEach
    void setUp() {
        solver = new SubarraysWithScoreLessThanKV1();
    }

    @Test
    @DisplayName("Should count valid subarrays in a standard case")
    void testStandardCase() {
        // nums = [2, 1, 4, 3, 5], k = 10
        // Valid subarrays: [2], [1], [4], [3], [5], [2,1]
        // [2,1] score: (2+1)*2 = 6 < 10.
        // [1,4] score: (1+4)*2 = 10 (Not strictly less than 10).
        int[] nums = {2, 1, 4, 3, 5};
        long k = 10;
        assertEquals(6, solver.countSubarrays(nums, k));
    }

    @Test
    @DisplayName("Should return 0 if k is very small")
    void testNoValidSubarrays() {
        int[] nums = {10, 20, 30};
        long k = 5; // Even the smallest element [10]*1 is greater than 5
        assertEquals(0, solver.countSubarrays(nums, k));
    }

    @Test
    @DisplayName("Should count all possible subarrays if k is very large")
    void testAllValidSubarrays() {
        // For length 3, total subarrays = (3 * 4) / 2 = 6
        int[] nums = {1, 1, 1};
        long k = 100;
        assertEquals(6, solver.countSubarrays(nums, k));
    }

    @Test
    @DisplayName("Should handle single element arrays")
    void testSingleElement() {
        int[] nums = {5};
        assertEquals(1, solver.countSubarrays(nums, 6));
        assertEquals(0, solver.countSubarrays(nums, 5));
    }
}
