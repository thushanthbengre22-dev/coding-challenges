package com.bengre.educative.io.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertIntervalV1 {

    public int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int n = existingIntervals.length;
        int[][] intervals = Arrays.copyOf(existingIntervals, n + 1);
        intervals[n] = newInterval;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i <= n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int currentStart = res.get(res.size()-1)[0];
            int currentEnd = res.get(res.size()-1)[1];
            if (end >= currentStart && start <= currentEnd) {
                res.set(res.size()-1, new int[]{Math.min(start, currentStart), Math.max(end, currentEnd)});
            } else {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
