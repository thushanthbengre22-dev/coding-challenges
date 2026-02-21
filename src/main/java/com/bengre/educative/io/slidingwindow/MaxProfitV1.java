package com.bengre.educative.io.slidingwindow;

public class MaxProfitV1 {

    public static int maxProfit(int[] prices) {
        if ( prices.length == 1) {
            return 0;
        }
        int left = 0;
        int maxProfit = 0;
        int n = prices.length;
        int right = 1;
        while(right < n) {
            int currentProfit = prices[right] - prices[left];

            if (prices[left] < prices[right]) {
                maxProfit = Math.max(currentProfit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
