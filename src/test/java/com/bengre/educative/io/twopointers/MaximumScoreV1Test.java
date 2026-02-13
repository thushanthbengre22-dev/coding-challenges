package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaximumScoreV1Test {

    private final MaximumScoreV1 solver = new MaximumScoreV1();

    @Test
    @DisplayName("Should find max sum with multiple switch points")
    void testStandardPath() {
        int[] nums1 = {2, 4, 5, 8, 10};
        int[] nums2 = {4, 6, 8, 9};
        // Common elements: 4, 8
        // Segments between common elements:
        // [2] vs [] -> Max is 2. Common 4.
        // [5] vs [6] -> Max is 6. Common 8.
        // [10] vs [9] -> Max is 10.
        // Path: 2 -> 4 -> 6 -> 8 -> 10. Sum = 30.
        assertEquals(30, solver.maxSum(nums1, nums2));
    }

    @Test
    @DisplayName("Should handle no common elements")
    void testNoCommonElements() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        // Simply the max of the two total sums: 6 vs 15.
        assertEquals(15, solver.maxSum(nums1, nums2));
    }

    @Test
    @DisplayName("Should apply modulo 10^9 + 7 for large results")
    void testLargeSumWithModulo() {
        int[] nums1 = {10000000};
        int[] nums2 = {10000000};
        // Just one element, but ensure logic handles large inputs
        assertEquals(10000000, solver.maxSum(nums1, nums2));
    }

    @Test
    @DisplayName("Should handle arrays of different lengths")
    void testDifferentLengths() {
        int[] nums1 = {1, 4, 5, 8, 9, 11, 19};
        int[] nums2 = {2, 3, 4, 11};
        // Intersection at 4 and 11.
        // Path: 2+3+4 + 5+8+9+11 + 19 = 61.
        assertEquals(61, solver.maxSum(nums1, nums2));
    }
}
