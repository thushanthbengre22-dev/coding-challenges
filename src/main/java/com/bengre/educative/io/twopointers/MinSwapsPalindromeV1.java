package com.bengre.educative.io.twopointers;

public class MinSwapsPalindromeV1 {

    public int minMovesToMakePalindrome(String s) {
        if (isPalindrome(s.toCharArray())) {
            return 0;
        }
        char[] c = s.toCharArray();
        int n = c.length;
        int i=0;
        int j = n-1;
        int swaps = 0;
        while (i<j) {
            int k = j;
            while (c[i] != c[k]) {
                k--;
            }
            if (k ==i) {
                swapChar(c, i, i+1);
                swaps++;
                continue;
            }
            swaps = swaps + (j-k);
            swapChar(c, k, j);
            i++;
            j--;
        }

        return swaps;

    }

    public void swapChar(char[] c, int startIndex, int endIndex) {
        for (int i=startIndex; i < endIndex; i++) {
            char temp = c[i];
            c[i] = c[i+1];
            c[i+1] = temp;
        }
    }

    public boolean isPalindrome(char [] c) {
        int n = c.length;
        if (c.length == 1) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (c[i] != c[n-i-1]) {
                return false;
            }
        }
        return true;
    }
}
