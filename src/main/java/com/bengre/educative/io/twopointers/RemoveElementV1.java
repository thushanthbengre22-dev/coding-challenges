package com.bengre.educative.io.twopointers;

import java.util.Arrays;

public class RemoveElementV1 {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            if (nums[i] == val) {
                count++;
                shift(nums, i, val);
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    public void shift(int[] nums, int i, int val) {
        for(int k =i; k < nums.length -1; k++) {
            nums[k] = nums[k+1];
        }
        nums[nums.length-1] = val;
    }
}
