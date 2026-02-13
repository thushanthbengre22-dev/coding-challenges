package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RotateArrayV1Test {

    private final RotateArrayV1 solver = new RotateArrayV1();

    @Test
    @DisplayName("Should rotate a standard array by k steps")
    void testStandardRotation() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        // Expected: [5, 6, 7, 1, 2, 3, 4]
        solver.rotate(nums, k);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    @DisplayName("Should handle k being larger than array length")
    void testKGreaterThanLength() {
        int[] nums = {1, 2};
        int k = 3;
        // k % length = 3 % 2 = 1.
        // Expected: [2, 1]
        solver.rotate(nums, k);
        assertArrayEquals(new int[]{2, 1}, nums);
    }

    @Test
    @DisplayName("Should return the same array if k is 0 or multiple of length")
    void testKIsZeroOrMultiple() {
        int[] nums = {1, 2, 3};
        solver.rotate(nums, 0);
        assertArrayEquals(new int[]{1, 2, 3}, nums);

        solver.rotate(nums, 3);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    @DisplayName("Should handle single-element array")
    void testSingleElement() {
        int[] nums = {1};
        solver.rotate(nums, 100);
        assertArrayEquals(new int[]{1}, nums);
    }
}
