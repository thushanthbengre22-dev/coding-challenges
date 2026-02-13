package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveElementV1Test {

    private final RemoveElementV1 solver = new RemoveElementV1();

    @Test
    @DisplayName("Should remove occurrences and return correct count")
    void testStandardRemoval() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = solver.removeElement(nums, val);

        assertEquals(2, k, "Should return k=2");

        // Sort the first k elements to verify content regardless of order
        int[] result = Arrays.copyOfRange(nums, 0, k);
        Arrays.sort(result);
        assertArrayEquals(new int[]{2, 2}, result);
    }

    @Test
    @DisplayName("Should handle cases where all elements match val")
    void testRemoveAll() {
        int[] nums = {1, 1, 1};
        int val = 1;
        int k = solver.removeElement(nums, val);
        assertEquals(0, k);
    }

    @Test
    @DisplayName("Should handle cases where no elements match val")
    void testRemoveNone() {
        int[] nums = {1, 2, 3};
        int val = 5;
        int k = solver.removeElement(nums, val);
        assertEquals(3, k);
    }

    @Test
    @DisplayName("Should handle empty array")
    void testEmptyArray() {
        int[] nums = {};
        int k = solver.removeElement(nums, 0);
        assertEquals(0, k);
    }
}
