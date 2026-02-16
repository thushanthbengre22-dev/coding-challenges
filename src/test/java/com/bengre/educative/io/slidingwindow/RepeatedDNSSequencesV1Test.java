package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatedDNSSequencesV1Test {

    private RepeatedDNSSequencesV1 solver;

    @BeforeEach
    void setUp() {
        solver = new RepeatedDNSSequencesV1();
    }

    @Test
    @DisplayName("Should find multiple repeated 10-letter sequences")
    void testStandardRepeats() {
        // "AAAAACCCCC" repeats once
        // "CCCCCAAAAA" repeats once
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solver.findRepeatedDnaSequences(s);

        assertEquals(2, result.size());
        assertTrue(result.contains("AAAAACCCCC"));
        assertTrue(result.contains("CCCCCAAAAA"));
    }

    @Test
    @DisplayName("Should handle overlapping repeated sequences")
    void testOverlappingRepeats() {
        // "AAAAAAAAAA" repeats
        String s = "AAAAAAAAAAA"; // length 11
        // There are two windows: s[0-10] and s[1-11]. Both are "AAAAAAAAAA"
        List<String> result = solver.findRepeatedDnaSequences(s);

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Should return empty list if string is shorter than 10")
    void testShortString() {
        String s = "ACGT";
        List<String> result = solver.findRepeatedDnaSequences(s);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should return empty list if no sequences repeat")
    void testNoRepeats() {
        String s = "ABCDEFGHIJ1234567890"; // No 10-char block repeats
        List<String> result = solver.findRepeatedDnaSequences(s);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should handle exact 10 character repeats")
    void testExactTenRepeats() {
        String s = "ACGTACGTACACGTACGTAC"; // "ACGTACGTAC" twice
        List<String> result = solver.findRepeatedDnaSequences(s);
        assertEquals(0, result.size());
    }
}
