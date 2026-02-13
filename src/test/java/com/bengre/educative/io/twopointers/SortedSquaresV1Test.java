package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortedSquaresV1Test {

    private final SortedSquaresV1 solver = new SortedSquaresV1();

    @Test
    @DisplayName("Should handle arrays with both negative and positive numbers")
    void testMixedNumbers() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 16, 9, 100}; // Unsorted squares
        int[] correctlySorted = {0, 1, 9, 16, 100};

        assertArrayEquals(correctlySorted, solver.sortedSquares(nums));
    }

    @Test
    @DisplayName("Should handle arrays with only negative numbers")
    void testAllNegatives() {
        int[] nums = {-7, -3, -1};
        // Squares: 49, 9, 1 -> Sorted: 1, 9, 49
        assertArrayEquals(new int[]{1, 9, 49}, solver.sortedSquares(nums));
    }

    @Test
    @DisplayName("Should handle arrays with only positive numbers")
    void testAllPositives() {
        int[] nums = {1, 2, 3};
        assertArrayEquals(new int[]{1, 4, 9}, solver.sortedSquares(nums));
    }

    @Test
    @DisplayName("Should handle single element and zeros")
    void testEdgeCases() {
        assertArrayEquals(new int[]{0}, solver.sortedSquares(new int[]{0}));
        assertArrayEquals(new int[]{25}, solver.sortedSquares(new int[]{-5}));
    }
}
