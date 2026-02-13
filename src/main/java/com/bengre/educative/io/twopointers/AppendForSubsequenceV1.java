package com.bengre.educative.io.twopointers;

public class AppendForSubsequenceV1 {

    public int appendCharacters(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length;
        int nt = t.length;
        if (source.equals(target)) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < n && j < nt) {
            if (s[i] == t[j]) {
                j++;
            }
            i++;
        }
        return nt - j;
    }
}
