package com.bengre.educative.io.twopointers;

public class ValidWordAbbreviationV1 {

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] c = abbr.toCharArray();
        char[] w = word.toCharArray();
        int n = c.length;
        int m = w.length;
        int i=0;
        int j = 0;
        if (word.equals(abbr)) {
            return true;
        }
        if (m == 1 && n == 1 && (c[i] - '0') == 1) {
            return true;
        }
        if (n > m) {
            return false;
        }
        while (i < n && j < m) {
            if (c[i] == w[j]) {
                i++;
                j++;
            } else if (Character.isDigit(c[i])) {
                if ((c[i] - '0') == 0) {
                    return false;
                } else {
                    int num = 0;
                    while (i < n && Character.isDigit(c[i])) {
                        num = num * 10 + (c[i] - '0');
                        i++;
                    }
                    if (i > n-1) {
                        return m-j == num;
                    }
                    j = j + num;
                    if (j > m) {
                        return false;
                    }
                    if ( i < n && j < m && w[j] != c[i]) {
                        return false;
                    }
                }

            }  else {
                return false;
            }
        }
        if (i != n || j != m) {
            return false;
        }
        return true;
    }
}
