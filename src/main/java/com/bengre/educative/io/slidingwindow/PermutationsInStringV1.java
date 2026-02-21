package com.bengre.educative.io.slidingwindow;

public class PermutationsInStringV1 {

    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1Counts = new int[26];
        int[] windowCounts = new int[26];

        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n1; i++) {
            windowCounts[s2.charAt(i) - 'a']++;
        }

        if (arraysEqual(s1Counts, windowCounts)) return true;

        for (int i = n1; i < n2; i++) {
            windowCounts[s2.charAt(i) - 'a']++;

            windowCounts[s2.charAt(i - n1) - 'a']--;

            if (arraysEqual(s1Counts, windowCounts)) return true;
        }
        return false;
    }

    private boolean arraysEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
