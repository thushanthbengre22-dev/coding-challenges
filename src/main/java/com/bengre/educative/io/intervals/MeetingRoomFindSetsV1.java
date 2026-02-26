package com.bengre.educative.io.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomFindSetsV1 {
    public int findSets(int[][] intervals) {
        int n = intervals.length;
        List<Integer> res = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        res.add(intervals[0][1]);

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            System.out.println(start);
            System.out.println(end);
            boolean roomAssigned = false;
            for (int j = 0; j < res.size(); j++) {
                int meetingEnd = res.get(j);
                if (start >= meetingEnd) {
                    roomAssigned = true;
                    res.set(j, end);
                    break;
                }
            }
            if (!roomAssigned) {
                res.add(intervals[i][1]);
            }
        }
        return res.size();

    }
}
