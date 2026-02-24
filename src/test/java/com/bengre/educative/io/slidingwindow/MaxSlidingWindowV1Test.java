package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxSlidingWindowV1Test {

    private MaxSlidingWindowV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MaxSlidingWindowV1();
    }

    @Test
    @DisplayName("Should find maximums in a standard mixed array")
    void testStandardCase() {
        // [1, 3, -1, -3, 5, 3, 6, 7], w=3
        // [1, 3, -1] -> 3
        // [3, -1, -3] -> 3
        // [-1, -3, 5] -> 5
        // [-3, 5, 3] -> 5
        // [5, 3, 6] -> 6
        // [3, 6, 7] -> 7
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, solver.findMaxSlidingWindow(nums, 3));
    }

    @Test
    @DisplayName("Should handle window size of 1")
    void testWindowSizeOne() {
        // Every element is its own maximum
        int[] nums = {1, 2, 3};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, solver.findMaxSlidingWindow(nums, 1));
    }

    @Test
    @DisplayName("Should handle window size equal to array length")
    void testWindowSizeFull() {
        int[] nums = {1, 5, 2, 4};
        int[] expected = {5};
        assertArrayEquals(expected, solver.findMaxSlidingWindow(nums, 4));
    }

    @Test
    @DisplayName("Should handle strictly decreasing array")
    void testDecreasingArray() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3};
        assertArrayEquals(expected, solver.findMaxSlidingWindow(nums, 3));
    }

    @Test
    @DisplayName("Should handle negative numbers")
    void testNegativeNumbers() {
        int[] nums = {-7, -8, -7, 5, 7, 1, 6, 0};
        int[] expected = {-7, 5, 7, 7, 7, 6};
        assertArrayEquals(expected, solver.findMaxSlidingWindow(nums, 3));
    }
}
