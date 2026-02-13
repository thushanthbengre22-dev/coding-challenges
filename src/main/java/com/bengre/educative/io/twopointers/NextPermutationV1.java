package com.bengre.educative.io.twopointers;

public class NextPermutationV1 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i;
        int n = nums.length;
        for (i = n-1; i >= 1; i--){
            if (nums[i] > nums[i-1]) {
                int small = i;
                for (int k = n - 1; k >= i; k--) {
                    if (nums[k] > nums[i - 1]) {
                        small = k;
                        break;
                    }
                }

                int temp = nums[small];
                nums[small] = nums[i-1];
                nums[i-1] = temp;
                break;
            }
        }
        reverse(nums, i, n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
