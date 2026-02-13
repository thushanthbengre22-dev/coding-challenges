package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortColorsV1Test {

    private final SortColorsV1 solver = new SortColorsV1();

    @Test
    @DisplayName("Should sort a standard mixed array of 0s, 1s, and 2s")
    void testStandardArray() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};

        solver.sortColors(nums);

        assertArrayEquals(expected, nums, "The array was not sorted correctly.");
    }

    @Test
    @DisplayName("Should handle arrays with missing colors")
    void testMissingColors() {
        int[] nums = {2, 0, 1, 2, 0};
        int[] expected = {0, 0, 1, 2, 2};

        solver.sortColors(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("Should handle an already sorted array")
    void testAlreadySorted() {
        int[] nums = {0, 1, 2};
        int[] expected = {0, 1, 2};

        solver.sortColors(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("Should handle arrays of a single color")
    void testSingleColor() {
        int[] nums = {1, 1, 1};
        int[] expected = {1, 1, 1};

        solver.sortColors(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("Should handle empty or single-element arrays")
    void testEdgeCases() {
        int[] empty = {};
        solver.sortColors(empty);
        assertArrayEquals(new int[]{}, empty);

        int[] single = {0};
        solver.sortColors(single);
        assertArrayEquals(new int[]{0}, single);
    }
}