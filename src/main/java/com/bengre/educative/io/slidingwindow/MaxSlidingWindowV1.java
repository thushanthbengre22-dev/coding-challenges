package com.bengre.educative.io.slidingwindow;

import java.util.Arrays;

public class MaxSlidingWindowV1 {

    public int[] findMaxSlidingWindow(int[] nums, int w) {
        if (w == 1) {
            return nums;
        }
        int[] res = new int[nums.length-w +1];
        int left = 0;
        for (int right = left + w; right <= nums.length; right++) {
            res[left] = findLargest(Arrays.copyOfRange(nums, left, right));
            left++;
        }

        return res;

    }

    public int findLargest(int[] arr) {
        System.out.println(Arrays.toString(arr));
        if (arr.length == 1) {
            return arr[0];
        }
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
}
