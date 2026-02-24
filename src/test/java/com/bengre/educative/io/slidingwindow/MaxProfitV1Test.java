package com.bengre.educative.io.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxProfitV1Test {

    private MaxProfitV1 solver;

    @BeforeEach
    void setUp() {
        solver = new MaxProfitV1();
    }

    @Test
    @DisplayName("Should find max profit in a standard fluctuating market")
    void testStandardProfit() {
        // Buy on day 2 (price 1), sell on day 5 (price 6). Profit = 6-1 = 5.
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solver.maxProfit(prices));
    }

    @Test
    @DisplayName("Should return 0 when prices are strictly decreasing")
    void testNoProfitPossible() {
        // Price drops every day; no way to make money.
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, solver.maxProfit(prices));
    }

    @Test
    @DisplayName("Should handle a market with only two days")
    void testMinimumDays() {
        // Buy 1, sell 5. Profit 4.
        int[] prices = {1, 5};
        assertEquals(4, solver.maxProfit(prices));
    }

    @Test
    @DisplayName("Should return 0 if all prices are the same")
    void testFlatMarket() {
        int[] prices = {3, 3, 3, 3};
        assertEquals(0, solver.maxProfit(prices));
    }

    @Test
    @DisplayName("Should find profit when the best buying day is very late")
    void testLatePeak() {
        // Buy 2, sell 10. Profit 8.
        int[] prices = {10, 12, 2, 5, 10, 1};
        assertEquals(8, solver.maxProfit(prices));
    }
}
