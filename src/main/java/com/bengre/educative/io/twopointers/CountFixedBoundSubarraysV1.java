package com.bengre.educative.io.twopointers;
import java.util.*;

public class CountFixedBoundSubarraysV1 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i< n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                int smallest = Integer.MAX_VALUE;
                int largest = 0;
                for (int k = i; k <= j; k++) {
                    if (nums[k] < smallest) {
                        smallest = nums[k];
                    }
                    if (nums[k] > largest) {
                        largest = nums[k];
                    }
                    temp.add(nums[k]);
                }
                if (temp.contains(minK) && temp.contains(maxK) && smallest >= minK && largest <= maxK) {
                    res.add(temp);
                }
            }
        }
        return (long) res.size();

    }
}
