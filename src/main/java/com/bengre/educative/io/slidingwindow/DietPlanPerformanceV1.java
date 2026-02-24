package com.bengre.educative.io.slidingwindow;

import java.util.List;

public class DietPlanPerformanceV1 {

    public int dietPlanPerformance(List<Integer> calories, int k, int lower, int upper) {
        int n = calories.size();
        int points = 0;
        int left = 0;
        int windowSum = 0;
        for (int right = 0; right < n; right++) {
            windowSum += calories.get(right);
            if (right - left + 1 == k) {
                if (windowSum > upper) {
                    points++;
                } else if (windowSum < lower) {
                    points--;
                }
            }
            while (right - left + 1 >= k) {
                windowSum -= calories.get(left);
                left++;
            }
        }
        return points;
    }
}
