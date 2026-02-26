package com.bengre.educative.io.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertIntervalV1Test {

    private InsertIntervalV1 solver;

    @BeforeEach
    void setUp() {
        solver = new InsertIntervalV1();
    }

    @Test
    @DisplayName("Should insert and merge in the middle")
    void testMiddleMerge() {
        // [1,3] and [6,9] with new [2,5]
        // [2,5] overlaps with [1,3] -> [1,5]
        // Final: [[1,5], [6,9]]
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] expected = {{1, 5}, {6, 9}};
        assertArrayEquals(expected, solver.insertInterval(intervals, newInterval));
    }

    @Test
    @DisplayName("Should merge multiple existing intervals")
    void testMultipleMerge() {
        // [4,8] overlaps [3,5], [6,7], and [8,10]
        // Resulting merge: [3,10]
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        assertArrayEquals(expected, solver.insertInterval(intervals, newInterval));
    }

    @Test
    @DisplayName("Should handle empty initial intervals")
    void testEmptyInput() {
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] expected = {{5, 7}};
        assertArrayEquals(expected, solver.insertInterval(intervals, newInterval));
    }

    @Test
    @DisplayName("Should insert at the very beginning without merging")
    void testBeginningInsert() {
        int[][] intervals = {{5, 10}};
        int[] newInterval = {1, 2};
        int[][] expected = {{1, 2}, {5, 10}};
        assertArrayEquals(expected, solver.insertInterval(intervals, newInterval));
    }
}
