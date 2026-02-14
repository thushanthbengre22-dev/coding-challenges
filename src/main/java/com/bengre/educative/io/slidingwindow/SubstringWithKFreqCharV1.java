package com.bengre.educative.io.slidingwindow;

public class SubstringWithKFreqCharV1 {

    public long numberOfSubstrings(String s, int k) {
        int n = s.length();
        if (s.length() == 1) {
            return 1;
        }
        if (k == 1) {
            return ((long) n * (n+1))/2;
        }
        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for(int l = i; l <= j; l++) {
                    sb.append(s.charAt(l));
                }
                int[] freq = freqCount(sb.toString());
                if (maxWindowFrequency(freq) >= k) {
                    System.out.println(maxWindowFrequency(freq));
                    System.out.println(sb.toString());
                    res++;
                }
            }
        }

        return res;

    }

    public int[] freqCount(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    public int maxWindowFrequency(int[] freq) {
        int res = 0;
        for (int j : freq) {
            if (j > res) {
                res = j;
            }
        }
        return res;
    }
}
