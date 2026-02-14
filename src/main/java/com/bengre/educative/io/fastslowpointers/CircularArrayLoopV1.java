package com.bengre.educative.io.fastslowpointers;

public class CircularArrayLoopV1 {

    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length;
        int slow;
        int fast = 0;
        int k = 0;
        for (int i =0; i< n; i++) {
            slow = nums[i];
            k = i;
            fast = slow;
            int j = 0;
            while (j < n) {
                k = nextFast(nums, k, fast, n);
                fast = nums[k];
                if (j < 1 && slow == fast) {
                    break;
                }
                if (j >= 1 && slow == fast) {
                    return true;
                }
                if ((slow < 0 && fast > 0) || (slow > 0 && fast < 0)) {
                    break;
                }
                j++;
            }

        }
        return false;
    }

    public static int nextFast(int[] nums, int i, int slow, int n) {
        int fastInd = 0;
        if (slow > 0) {
            fastInd = (i + slow) % n;
        } else {
            int moveBackBy = Math.abs(slow);
            int fastIndex = (i-moveBackBy) % n;
            if (fastIndex < 0) {
                fastInd = fastIndex + n;
            } else {
                fastInd = fastIndex;
            }
        }
        return fastInd;
    }
}
