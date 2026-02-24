package com.bengre.educative.io.slidingwindow;

import java.util.Arrays;

public class MaxAvgSubarrayV1 {

    public double findMaxAverage(int[] nums, int k) {
        //Simplest solution would be to sort the array and take the avg of the rightmost window
        //But lets do sliding window here
        int n = nums.length;
        if (n == 1) {
            return (double) nums[0];
        }

        int left = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        for(int right = left + k; right <= n; right++) {
            double avg = calcAvg(Arrays.copyOfRange(nums, left, right));
            if (maxAvg < avg) {
                maxAvg = avg;
            }
            left++;
        }
        return maxAvg;

    }

    public double calcAvg(int[] nums) {
        double avg = 0.0;
        System.out.println(Arrays.toString(nums));
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        System.out.println(sum/nums.length);
        return (double) sum/nums.length;
    }
}
