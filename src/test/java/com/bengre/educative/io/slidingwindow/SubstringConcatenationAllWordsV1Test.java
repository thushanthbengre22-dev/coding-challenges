package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class SubstringConcatenationAllWordsV1Test {

    private SubstringConcatenationAllWordsV1 solver;

    @BeforeEach
    void setUp() {
        solver = new SubstringConcatenationAllWordsV1();
    }

    @Test
    @DisplayName("Should find multiple starting indices in a standard string")
    void testStandardCase() {
        // words are length 3. Target length = 6.
        // "barfoo" starts at 0, "foobar" starts at 9.
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = solver.findSubstring(s, words);
        Collections.sort(result);
        assertEquals(Arrays.asList(0, 9), result);
    }

    @Test
    @DisplayName("Should return empty list if no concatenation exists")
    void testNoMatch() {
        String s = "wordgoodgoodgoodwordnumber";
        String[] words = {"word", "good", "best", "word"};
        // "best" is missing from s in the required contiguous sequence
        assertTrue(solver.findSubstring(s, words).isEmpty());
    }

    @Test
    @DisplayName("Should work when s length is exactly the concatenation length")
    void testExactLengthMatch() {
        String s = "foobar";
        String[] words = {"foo", "bar"};
        assertEquals(Arrays.asList(0), solver.findSubstring(s, words));
    }
}
