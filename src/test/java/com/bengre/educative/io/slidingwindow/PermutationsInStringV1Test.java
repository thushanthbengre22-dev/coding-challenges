package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PermutationsInStringV1Test {

    private PermutationsInStringV1 solver;

    @BeforeEach
    void setUp() {
        solver = new PermutationsInStringV1();
    }

    @Test
    @DisplayName("Should return true when a permutation exists")
    void testPermutationExists() {
        // "ba" is a permutation of "ab" found in "eidbaooo"
        assertTrue(solver.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    @DisplayName("Should return false when no permutation exists")
    void testNoPermutation() {
        // "ab" requires 'a' and 'b'. "eidboaoo" has them, but not together.
        assertFalse(solver.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    @DisplayName("Should return true if strings are identical")
    void testIdenticalStrings() {
        assertTrue(solver.checkInclusion("hello", "hello"));
    }

    @Test
    @DisplayName("Should return false if s1 is longer than s2")
    void testS1LongerThanS2() {
        assertFalse(solver.checkInclusion("longer", "short"));
    }

    @Test
    @DisplayName("Should handle multiple occurrences of the same character")
    void testDuplicateCharacters() {
        // s1 needs two 'a's. s2 has "aa" at the end.
        assertTrue(solver.checkInclusion("aa", "beebaac"));
    }
}
