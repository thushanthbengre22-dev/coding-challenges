package com.bengre.educative.io.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationAllWordsV1 {
    public List<Integer> findSubstring (String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int wordLength = words[0].length();
        int totalLength = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String w: words) {
            totalLength += w.length();
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        if (n < totalLength) {
            return new ArrayList<>();
        }
        for (int left = 0; left <= n - totalLength; left++) {
            int right = left;
            HashMap<String, Integer> tempMap = new HashMap<>();
            tempMap.putAll(map);
            System.out.println (right);
            System.out.println (left);
            String subStr = s.substring(right, right + wordLength);
            System.out.println(subStr);
            while(right + wordLength <= n && tempMap.get(subStr) != null && tempMap.get(subStr) !=0) {
                tempMap.put(subStr, tempMap.get(subStr) - 1);
                if (right + wordLength < n) {
                    right = right + wordLength;
                    System.out.println("InsideLoopsBefore" + subStr);
                    if (right + wordLength < n) {
                        subStr = s.substring(right, right + wordLength);
                    } else {
                        subStr = s.substring(right);
                    }
                    System.out.println("InsideLoopsAfter" + subStr);
                } else {
                    break;
                }
            }
            if (isMapZero(tempMap, words)) {
                System.out.println("Hit");
                res.add(left);
            }

        }
        return res;
    }

    public Boolean isMapZero(HashMap<String, Integer> map, String[] words) {
        for (String w: words) {
            if (map.get(w) > 0) {
                return false;
            }
        }
        return true;
    }
}
