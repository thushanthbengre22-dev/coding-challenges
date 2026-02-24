package com.bengre.educative.io.slidingwindow;

public class SubarraysWithScoreLessThanKV1 {

    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j< n; j++) {
                long score = 0;
                for (int l = i; l <= j; l++) {
                    score += nums[l];
                }
                System.out.println(score);
                score = score * (j-i+1);
                if (score < k) {
                    res++;
                }
            }
        }

        return res;


    }
}
