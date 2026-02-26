package com.bengre.educative.io.intervals;

import java.util.Arrays;

public class MergeIntervalsV1 {

    public int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;
        int k = -1;
        int[][] res = new int[n][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            if (i == 0){
                k++;
                res[k][0] = intervals[i][0];
                res[k][1] = intervals[i][1];
            } else {
                int currentEnd = res[k][1];
                int start = intervals[i][0];
                int end = intervals[i][1];
                System.out.println(currentEnd);
                System.out.println(start);
                System.out.println(end);
                if (start <= currentEnd && currentEnd <= end) {
                    res[k][1] = end;
                } else if (start > currentEnd) {
                    System.out.println("adding" + i);
                    k++;
                    res[k][0] = intervals[i][0];
                    res[k][1] = intervals[i][1];
                }
            }
        }

        return Arrays.copyOfRange(res, 0, k+1);
    }
}
