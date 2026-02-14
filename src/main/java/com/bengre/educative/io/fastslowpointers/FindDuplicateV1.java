package com.bengre.educative.io.fastslowpointers;

public class FindDuplicateV1 {

    public int findDuplicate(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i =0; i<n-1; i++) {
            for (int j=i+1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    res = nums[j];
                }
            }
        }

        return res;

    }
}
