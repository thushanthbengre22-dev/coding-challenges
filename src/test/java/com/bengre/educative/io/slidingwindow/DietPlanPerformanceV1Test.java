package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DietPlanPerformanceV1Test {

    private DietPlanPerformanceV1 solver;

    @BeforeEach
    void setUp() {
        solver = new DietPlanPerformanceV1();
    }

    @Test
    @DisplayName("Should gain points when calories exceed upper")
    void testGainPoints() {
        // k=2, lower=3, upper=3.
        // Window [1,2] sum=3 (Normal)
        // Window [2,3] sum=5 (Gain 1)
        // Window [3,4] sum=7 (Gain 1)
        // Window [4,5] sum=9 (Gain 1). Total = 3
        int[] calories = {1, 2, 3, 4, 5};
        List<Integer> caloriesList = new ArrayList<>(calories.length);

        for (int i : calories) {
            caloriesList.add(i);
        }
        int k = 2, lower = 3, upper = 3;
        assertEquals(3, solver.dietPlanPerformance(caloriesList, k, lower, upper));
    }

    @Test
    @DisplayName("Should lose points when calories are below lower")
    void testLosePoints() {
        // k=1, lower=3, upper=3.
        // [6] (+1), [5] (+1), [0] (-1). Total = 1
        int[] calories = {6, 5, 0};
        List<Integer> caloriesList = new ArrayList<>(calories.length);

        for (int i : calories) {
            caloriesList.add(i);
        }
        int k = 1, lower = 3, upper = 3;
        assertEquals(1, solver.dietPlanPerformance(caloriesList, k, lower, upper));
    }

    @Test
    @DisplayName("Should result in negative points")
    void testNegativePoints() {
        // k=2, lower=10, upper=15
        // [3,2] sum=5 (-1)
        // [2,1] sum=3 (-1). Total = -2
        int[] calories = {3, 2, 1};
        List<Integer> caloriesList = new ArrayList<>(calories.length);

        for (int i : calories) {
            caloriesList.add(i);
        }
        int k = 2, lower = 10, upper = 15;
        assertEquals(-2, solver.dietPlanPerformance(caloriesList, k, lower, upper));
    }

    @Test
    @DisplayName("Should handle k equal to array length")
    void testKEqualsLength() {
        int[] calories = {2, 2, 2};
        List<Integer> caloriesList = new ArrayList<>(calories.length);

        for (int i : calories) {
            caloriesList.add(i);
        }
        int k = 3, lower = 1, upper = 5;
        // Window [2,2,2] sum=6 (+1)
        assertEquals(1, solver.dietPlanPerformance(caloriesList, k, lower, upper));
    }
}
