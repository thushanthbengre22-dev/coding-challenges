package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FruitsIntoBasketV1Test {
    private FruitsIntoBasketV1 solver;

    @BeforeEach
    void setUp() {
        solver = new FruitsIntoBasketV1();
    }

    @Test
    @DisplayName("Should handle standard case with multiple types")
    void testStandardCase() {
        // [1, 2, 1, 2, 3] -> [1, 2, 1, 2] is length 4
        int[] fruits = {1, 2, 1, 2, 3};
        assertEquals(4, solver.totalFruit(fruits));
    }

    @Test
    @DisplayName("Should handle three types alternating")
    void testThreeTypes() {
        // [1, 2, 3, 2, 2] -> [2, 3, 2, 2] is length 4
        int[] fruits = {1, 2, 3, 2, 2};
        assertEquals(4, solver.totalFruit(fruits));
    }

    @Test
    @DisplayName("Should handle all fruits being the same type")
    void testAllSameType() {
        int[] fruits = {1, 1, 1, 1};
        assertEquals(4, solver.totalFruit(fruits));
    }

    @Test
    @DisplayName("Should handle exactly two types")
    void testTwoTypes() {
        int[] fruits = {0, 1, 0, 1, 0};
        assertEquals(5, solver.totalFruit(fruits));
    }

    @Test
    @DisplayName("Should handle a large variety of fruits")
    void testManyTypes() {
        // [1, 2, 3, 4, 5] -> Any two adjacent trees (length 2)
        int[] fruits = {1, 2, 3, 4, 5};
        assertEquals(2, solver.totalFruit(fruits));
    }

    @Test
    @DisplayName("Should handle single tree")
    void testSingleTree() {
        int[] fruits = {1};
        assertEquals(1, solver.totalFruit(fruits));
    }
}