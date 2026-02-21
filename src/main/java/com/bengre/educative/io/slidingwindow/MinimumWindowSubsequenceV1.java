package com.bengre.educative.io.slidingwindow;

public class MinimumWindowSubsequenceV1 {

    public String minWindow(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return "";
        }
        if ( s1.length() == 1 && s1.charAt(0) == s2.charAt(0)) {
            return s1;
        }
        if ( s1.length() == 1 && s1 != s2) {
            return "";
        }
        char c = s2.charAt(0);
        String res = s1 + "abc";
        for (int right = 0; right < s1.length(); right++) {
            String temp = "";
            if (s1.charAt(right) == c) {
                temp = validSubstring(s1.substring(right), s2);
                if (temp != "" && temp.length() < res.length()) {
                    res = temp;
                }
            }
        }

        if ( res.equals(s1+"abc")) {
            return "";
        } else {
            return res;
        }
    }

    public String validSubstring(String s1, String s2) {
        int left = 0;
        int s2Counter = 0;
        for (int right = 0; right < s1.length(); right++) {
            if (s1.charAt(right) == s2.charAt(s2Counter)) {
                if (s2Counter < s2.length() - 1) {
                    s2Counter++;
                } else {
                    return s1.substring(left, right +1);
                }
            }
        }
        return "";
    }
}
