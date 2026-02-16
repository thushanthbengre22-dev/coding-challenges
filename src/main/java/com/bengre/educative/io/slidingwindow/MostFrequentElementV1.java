package com.bengre.educative.io.slidingwindow;

import java.util.*;

public class MostFrequentElementV1 {
    public int maxFrequency(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int left = 0;
        int windowSum = 0;
        int largest =1;
        for (int right = 0; right <= nums.length - 1; right++) {
            windowSum = windowSum + nums[right];
            while ((((right-left+1) * nums[right]) - windowSum) > k) {
                windowSum = windowSum - nums[left];
                left++;
            }
            largest = Math.max(largest, (right-left+1));
        }
        return largest;
    }
}
