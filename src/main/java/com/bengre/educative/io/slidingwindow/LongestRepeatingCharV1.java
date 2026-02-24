package com.bengre.educative.io.slidingwindow;

public class LongestRepeatingCharV1 {

    public int longestRepeatingCharacterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        if ( k == s.length()) {
            return s.length();
        }
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0, low = 0;
        for (int high = 0; high < s.length(); high++) {
            count[s.charAt(high) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(high) - 'A']);
            while ((high - low + 1) - maxCount > k) {
                count[s.charAt(low) - 'A']--;
                low++;
            }
            maxLength = Math.max(maxLength, high - low + 1);
        }
        return maxLength;
    }

}
