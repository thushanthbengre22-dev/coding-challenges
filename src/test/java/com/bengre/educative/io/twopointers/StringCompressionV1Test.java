package com.bengre.educative.io.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCompressionV1Test {

    private final StringCompressionV1 solver = new StringCompressionV1();

    @Test
    @DisplayName("Should compress groups of different characters correctly")
    void testStandardCompression() {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        // Compressed: ['a', '2', 'b', '2', 'c', '3']
        int newLength = solver.compress(input);

        assertEquals(6, newLength);
        assertArrayElementsEqual(new char[]{'a', '2', 'b', '2', 'c', '3'}, input, newLength);
    }

    @Test
    @DisplayName("Should not append '1' if the group length is 1")
    void testSingleCharacterGroup() {
        char[] input = {'a'};
        int newLength = solver.compress(input);

        assertEquals(1, newLength);
        assertEquals('a', input[0]);
    }

    @Test
    @DisplayName("Should handle groups with length >= 10 (multiple digits)")
    void testLongGroups() {
        char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        // 'a' (1), 'b' (12) -> ['a', 'b', '1', '2']
        int newLength = solver.compress(input);

        assertEquals(4, newLength);
        assertArrayElementsEqual(new char[]{'a', 'b', '1', '2'}, input, newLength);
    }

    @Test
    @DisplayName("Should handle alternating characters")
    void testAlternating() {
        char[] input = {'a', 'b', 'c'};
        int newLength = solver.compress(input);
        assertEquals(3, newLength);
        assertArrayElementsEqual(new char[]{'a', 'b', 'c'}, input, newLength);
    }

    // Custom helper to check only the relevant part of the array
    private void assertArrayElementsEqual(char[] expected, char[] actual, int length) {
        for (int i = 0; i < length; i++) {
            assertEquals(expected[i], actual[i], "Mismatch at index " + i);
        }
    }
}
