package com.bengre.educative.io.fastslowpointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindDuplicateV1Test {

    private FindDuplicateV1 finder;

    @BeforeEach
    void setUp() {
        finder = new FindDuplicateV1();
    }

    @Test
    @DisplayName("Should find duplicate when it appears exactly twice")
    void testBasicDuplicate() {
        // n=4, array length=5, duplicate is 2
        int[] nums = {1, 3, 4, 2, 2};
        assertEquals(2, finder.findDuplicate(nums));
    }

    @Test
    @DisplayName("Should find duplicate when it appears more than twice")
    void testMultipleOccurrences() {
        // n=3, array length=4, duplicate is 3
        int[] nums = {3, 1, 3, 3};
        assertEquals(3, finder.findDuplicate(nums));
    }

    @Test
    @DisplayName("Should find duplicate in the smallest possible array (n=1)")
    void testSmallestArray() {
        // n=1, array length=2, duplicate must be 1
        int[] nums = {1, 1};
        assertEquals(1, finder.findDuplicate(nums));
    }

    @Test
    @DisplayName("Should find duplicate when it is at the beginning and end")
    void testDuplicateAtEdges() {
        // n=4, duplicate is 1
        int[] nums = {1, 2, 3, 4, 1};
        assertEquals(1, finder.findDuplicate(nums));
    }

    @Test
    @DisplayName("Should find duplicate when all elements are the same")
    void testAllElementsSame() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals(2, finder.findDuplicate(nums));
    }
}
