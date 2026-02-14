package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubarraysWithKDistinctV1Test {

    private SubarraysWithKDistinctV1 solver;

    @BeforeEach
    void setUp() {
        solver = new SubarraysWithKDistinctV1();
    }

    @Test
    @DisplayName("Should find correct count for standard array")
    void testStandardCase() {
        // nums = [1,2,1,2,3], k = 2
        // Subarrays with exactly 2 distinct: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        assertEquals(7, solver.subarraysWithKDistinct(nums, k));
    }

    @Test
    @DisplayName("Should handle k = 1")
    void testKEqualsOne() {
        // Only subarrays with 1 distinct element: [1], [2], [1], [2]
        int[] nums = {1, 2, 1, 2};
        int k = 1;
        assertEquals(4, solver.subarraysWithKDistinct(nums, k));
    }

    @Test
    @DisplayName("Should return 0 when k is greater than distinct elements")
    void testKTooLarge() {
        int[] nums = {1, 2, 1};
        int k = 3;
        assertEquals(0, solver.subarraysWithKDistinct(nums, k));
    }

    @Test
    @DisplayName("Should handle array with all identical elements")
    void testAllIdentical() {
        // [1,1,1], k = 1. All subarrays are valid: [1], [1], [1], [1,1], [1,1], [1,1,1]
        int[] nums = {1, 1, 1};
        int k = 1;
        assertEquals(6, solver.subarraysWithKDistinct(nums, k));
    }
}
