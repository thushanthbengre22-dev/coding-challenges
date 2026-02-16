package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MostFrequentElementV1Test {

    private MostFrequentElementV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MostFrequentElementV1();
    }

    @Test
    @DisplayName("Should find max frequency for a small array")
    void testStandardCase() {
        // [1, 2, 4], k=5 -> [4, 4, 4] is possible because (4-1)+(4-2) = 5.
        // Result: 3
        int[] nums = {1, 2, 4};
        assertEquals(3, solver.maxFrequency(nums, 5));
    }

    @Test
    @DisplayName("Should handle case where k is small")
    void testSmallK() {
        // [1, 4, 8, 13], k=5 -> [4, 4, 8, 13] or [1, 8, 8, 13]
        // Best we can do is frequency 2
        int[] nums = {1, 4, 8, 13};
        assertEquals(2, solver.maxFrequency(nums, 5));
    }

    @Test
    @DisplayName("Should handle already frequent elements")
    void testAlreadyFrequent() {
        // [3, 9, 6], k=2 -> [6, 9, 6] (freq 2) or [3, 6, 6] is not possible.
        // After sorting: [3, 6, 9]. (6-3)=3 (too big for k=2).
        // Max freq is 1.
        int[] nums = {3, 9, 6};
        assertEquals(1, solver.maxFrequency(nums, 2));
    }

    @Test
    @DisplayName("Should handle large k that makes all elements equal")
    void testLargeK() {
        int[] nums = {1, 10, 100};
        assertEquals(3, solver.maxFrequency(nums, 200));
    }

    @Test
    @DisplayName("Should handle single element array")
    void testSingleElement() {
        int[] nums = {10};
        assertEquals(1, solver.maxFrequency(nums, 100));
    }


}
