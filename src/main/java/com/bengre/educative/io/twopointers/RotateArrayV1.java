package com.bengre.educative.io.twopointers;

public class RotateArrayV1 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }

        int n = nums.length;
        int shift = k%n;
        for (int i = 0; i< shift; i++) {
            int temp = nums[n-1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
}
