package com.bengre.educative.io.slidingwindow;

public class MinimumSizeSubArraySumV1 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            if (nums[0] < target) {
                return 0;
            } else {
                return 1;
            }
        }

        int left = 0;
        int right = 0;
        int windowSum = 0;
        int minSize = nums.length + 1;
        while (right < nums.length) {
            windowSum = windowSum + (nums[right]);
            while (windowSum >= target) {
                windowSum = windowSum - nums[left];
                minSize = Math.min(minSize, (right-left+1));
                left++;
            }
            right++;
        }

        if (minSize == nums.length +1) {
            return 0;
        } else {
            return minSize;
        }

    }
}
