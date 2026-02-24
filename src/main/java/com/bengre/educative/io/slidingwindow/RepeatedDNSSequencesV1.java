package com.bengre.educative.io.slidingwindow;

import java.util.*;

public class RepeatedDNSSequencesV1 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<String>();
        }
        HashSet<String> res = new HashSet<>();
        HashSet<String> hash = new HashSet<>();
        for (int left = 0; left < s.length() - 10; left++) {
            int right = left+10;
            System.out.println(s.substring(left, right));
            if(!hash.add(s.substring(left, right))) {
                res.add(s.substring(left, right));
            };
        }
        return new ArrayList<String>(res);

    }
}
