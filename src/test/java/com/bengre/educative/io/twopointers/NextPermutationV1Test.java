package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextPermutationV1Test {

    private final NextPermutationV1 solver = new NextPermutationV1();

    @Test
    @DisplayName("Should find the next lexicographical permutation for a standard case")
    void testStandardNextPermutation() {
        int[] nums = {1, 2, 3};
        solver.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 3, 2}, nums);

        int[] nums2 = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        solver.nextPermutation(nums2);
        // Step 1: find 4, Step 2: find 5, Step 3: swap 4&5, Step 4: reverse suffix
        assertArrayEquals(new int[]{1, 5, 8, 5, 1, 3, 4, 6, 7}, nums2);
    }

    @Test
    @DisplayName("Should rearrange to lowest order if current is highest (Descending Case)")
    void testHighestToLowest() {
        int[] nums = {3, 2, 1};
        solver.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    @DisplayName("Should handle arrays with duplicate values")
    void testDuplicates() {
        int[] nums = {1, 1, 5};
        solver.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 5, 1}, nums);
    }

    @Test
    @DisplayName("Should handle single element array")
    void testSingleElement() {
        int[] nums = {1};
        solver.nextPermutation(nums);
        assertArrayEquals(new int[]{1}, nums);
    }
}
