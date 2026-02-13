package com.bengre.educative.io.twopointers;

import java.util.Arrays;

public class SortedSquaresV1 {

    public int[] sortedSquares(int[] nums) {
        int[] resInt = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            resInt[i] = nums[i] * nums[i];
        }
        Arrays.sort(resInt);
        return resInt;

    }
}
