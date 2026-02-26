package com.bengre.educative.io.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeIntervalsV1Test {

    private MergeIntervalsV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MergeIntervalsV1();
    }

    @Test
    @DisplayName("Should merge multiple overlapping intervals")
    void testStandardOverlap() {
        // [1,3] and [2,6] overlap -> [1,6]
        // [8,10] and [15,18] do not overlap
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(expected, solver.mergeIntervals(intervals));
    }

    @Test
    @DisplayName("Should merge when one interval is completely inside another")
    void testContainedInterval() {
        // [1,10] completely swallows [4,5]
        int[][] intervals = {{1, 10}, {4, 5}};
        int[][] expected = {{1, 10}};
        assertArrayEquals(expected, solver.mergeIntervals(intervals));
    }

    @Test
    @DisplayName("Should merge intervals that touch at the exact same point")
    void testTouchingIntervals() {
        // [1,4] and [4,5] share the point 4. Since they are 'closed', they merge.
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solver.mergeIntervals(intervals));
    }

    @Test
    @DisplayName("Should handle single interval or empty input")
    void testSingleInterval() {
        int[][] intervals = {{1, 5}};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solver.mergeIntervals(intervals));
    }
}
