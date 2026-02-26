package com.bengre.educative.io.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeetingRoomFindSetsV1Test {

    private MeetingRoomFindSetsV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MeetingRoomFindSetsV1();
    }

    @Test
    @DisplayName("Should require multiple rooms for overlapping meetings")
    void testOverlappingMeetings() {
        // [0, 30] and [5, 10] overlap. [0, 30] and [15, 20] overlap.
        // But [5, 10] and [15, 20] do NOT overlap.
        // Max concurrent meetings = 2.
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        assertEquals(2, solver.findSets(intervals));
    }

    @Test
    @DisplayName("Should require 1 room for back-to-back meetings")
    void testBackToBack() {
        // End time is exclusive. Meeting 1 ends at 10, Meeting 2 starts at 10.
        // Room becomes available exactly at 10.
        int[][] intervals = {{0, 10}, {10, 20}, {20, 30}};
        assertEquals(1, solver.findSets(intervals));
    }

    @Test
    @DisplayName("Should require 1 room for non-overlapping meetings")
    void testNoOverlap() {
        int[][] intervals = {{7, 10}, {2, 4}};
        assertEquals(1, solver.findSets(intervals));
    }

    @Test
    @DisplayName("Should handle multiple meetings starting at same time")
    void testSameStartTime() {
        int[][] intervals = {{1, 10}, {1, 10}, {1, 10}};
        assertEquals(3, solver.findSets(intervals));
    }
}
