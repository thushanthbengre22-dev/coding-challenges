package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionLabelsV1Test {

    private final PartitionLabelsV1 solver = new PartitionLabelsV1();

    @Test
    @DisplayName("Should partition a standard string into max possible parts")
    void testStandardPartition() {
        String s = "ababcbacadefegdehijhklij";
        // Partitions: "ababcbaca", "defegde", "hijhklij"
        List<Integer> expected = Arrays.asList(9, 7, 8);
        assertEquals(expected, solver.partitionLabels(s));
    }

    @Test
    @DisplayName("Should return a single partition if all characters are unique or the same")
    void testSinglePartition() {
        assertEquals(Arrays.asList(1, 1, 1), solver.partitionLabels("abc"));
        assertEquals(Arrays.asList(5), solver.partitionLabels("aaaaa"));
    }

    @Test
    @DisplayName("Should handle two distinct groups")
    void testTwoGroups() {
        String s = "eccbbbbdec";
        // Everything must be in one group because 'e' and 'c' are at the ends
        assertEquals(Arrays.asList(10), solver.partitionLabels(s));
    }
}
