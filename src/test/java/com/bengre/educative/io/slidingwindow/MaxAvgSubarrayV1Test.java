package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxAvgSubarrayV1Test {

    private MaxAvgSubarrayV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MaxAvgSubarrayV1();
    }

    @Test
    @DisplayName("Should find max average in a mixed array")
    void testMixedArray() {
        // Window of 4: [12, -5, -6, 50] sum is 51. Avg = 51/4 = 12.75
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        assertEquals(12.75, solver.findMaxAverage(nums, k), 0.00001);
    }

    @Test
    @DisplayName("Should handle all negative numbers")
    void testAllNegatives() {
        // Max average should be -1.0
        int[] nums = {-1, -12, -5, -6, -50, -3};
        int k = 1;
        assertEquals(-1.0, solver.findMaxAverage(nums, k), 0.00001);
    }

    @Test
    @DisplayName("Should work when k equals array length")
    void testKEqualsLength() {
        int[] nums = {5, 5, 5, 5};
        int k = 4;
        assertEquals(5.0, solver.findMaxAverage(nums, k), 0.00001);
    }

    @Test
    @DisplayName("Should handle large values near constraints")
    void testLargeValues() {
        int[] nums = {10000, 10000, 10000};
        int k = 2;
        assertEquals(10000.0, solver.findMaxAverage(nums, k), 0.00001);
    }
}
