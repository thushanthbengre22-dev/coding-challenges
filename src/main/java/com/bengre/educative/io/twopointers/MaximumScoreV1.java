package com.bengre.educative.io.twopointers;

public class MaximumScoreV1 {

     int MOD = 1_000_000_007;
    public  int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) sum1 = (sum1 + nums1[i++]) % MOD;
            else if (nums1[i] > nums2[j]) sum2 = (sum2 + nums2[j++]) % MOD;
            else {
                res = (res + Math.max(sum1, sum2) + nums1[i]) % MOD;
                sum1 = 0; sum2 = 0;
                i++; j++;
            }
        }
        // Add remaining sums after loop
        while (i < n) sum1 = (sum1 + nums1[i++]) % MOD;
        while (j < m) sum2 = (sum2 + nums2[j++]) % MOD;
        res = (res + Math.max(sum1, sum2)) % MOD;
        return res;
    }
}
