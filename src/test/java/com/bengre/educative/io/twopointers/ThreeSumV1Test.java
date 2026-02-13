package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumV1Test {

    private final ThreeSumV1 solver = new ThreeSumV1();

    @Test
    @DisplayName("Should find multiple unique triplets that sum to zero")
    void testStandardCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // Expected: [[-1, -1, 2], [-1, 0, 1]]
        List<List<Integer>> result = solver.threeSum(nums);

        assertEquals(2, result.size(), "Should find exactly 2 unique triplets");

        // Sorting individual triplets to make comparison easier
        for (List<Integer> triplet : result) Collections.sort(triplet);

        assertTrue(result.contains(Arrays.asList(-1, -1, 2)));
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    @DisplayName("Should return empty list when no triplets sum to zero")
    void testNoMatch() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = solver.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should handle all zeros")
    void testAllZeros() {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> result = solver.threeSum(nums);
        assertEquals(1, result.size(), "Should only return one [0,0,0] triplet");
        assertEquals(Arrays.asList(0, 0, 0), result.get(0));
    }

    @Test
    @DisplayName("Should handle the minimum array length constraint")
    void testSmallestArray() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> result = solver.threeSum(nums);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(-1, 0, 1), result.get(0));
    }


}
